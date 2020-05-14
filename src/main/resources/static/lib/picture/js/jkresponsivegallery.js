/**
 * JK Responsive Gallery Script
 * Copyright JavaScript Kit (www.javascriptkit.com)
 * Updated: Aug 26th, 15'
 * Updated March 14thm 16' to V2.0: Adds Youtube videos support, bug fixes
 * Visit JavaScript Kit at http://www.javascriptkit.com/ for full source code       
 */

var jkyoutubeapidfd = $.Deferred()

function onYouTubeIframeAPIReady(){
	jkyoutubeapidfd.resolve()
}

(function($){


	document.createElement('figure') // for lesser IEs sake
	document.createElement('figcaption') // for lesser IEs sake

  var tag = document.createElement('script')
  tag.src = "https://www.youtube.com/iframe_api"
  var firstScriptTag = document.getElementsByTagName('script')[0]
  firstScriptTag.parentNode.insertBefore(tag, firstScriptTag)

	var youtubeplayer = null
	var videoaspectratio = 1.77 // 16:9 aspect ratio for video
	var isYoutubeReg = /(youtube?\.com|youtu\.be)/i
	// RegExp from: https://github.com/jsor/lity/blob/master/src/lity.js
	var youTubeIdReg = /(youtube?\.com|youtu\.be)\/(watch\?v=|v\/|u\/|embed\/?)?([\w-]{11})(.*)?/i
	var captionclass = 'rcaption'

	var KEYCODE_ESC = 27
			KEYCODE_LEFT = 37
			KEYCODE_RIGHT = 39

	var updatedimensionstimer = null

	var defaults = {
		autoclose: true,
		media: [], // leave this intact
		fxduration: 150
	}

	var galleryui = '<div class="responsivegallery">'
								+ '<div class="galleryinner">'
								+ '<div class="figurearea"></div>'
								+ '<div class="close"><span class="icon-cross"></span></div>'
								+ '<div class="leftnav"><span class="icon-arrow-left"></span></div><div class="rightnav"><span class="icon-arrow-right"></span></div>'
								+ '<div class="loadingdiv"><span class="icon-spinner"></span></div>'
								+ '<div class="errordiv"><span class="icon-cancel-circle"></span></div>'
								+ '</div>' // end galleryinner
								+ '</div>'


	function buildfigure(mediafigure, curmedia, totalmedia){
		var countermarkup = (totalmedia>1)? '<span class="counter">' + (curmedia+1) + '/' + totalmedia + '</span>' : ''
		var figurehtml = '<figure>\n'
		figurehtml += '<img src="' + mediafigure[0] + '" />\n'
		if (mediafigure[1] || totalmedia > 1){
			figurehtml += '<figcaption class="thecaption"><div class="captioninner">' + countermarkup + (mediafigure[1] || "") + '</div></figcaption>\n'
		}
		figurehtml += '</figure>'
		return figurehtml
	}

	function buildvideocontainer(mediafigure, curmedia, totalmedia){
		var countermarkup = (totalmedia>1)? '<span class="counter">' + (curmedia+1) + '/' + totalmedia + '</span>' : ''
		var videohtml = '<div class="jkvideocontainer">\n'
		videohtml += '<div class="jkvideowrapper"><div id="jkvideotemp"></div></div>\n'
		if (mediafigure[1] || totalmedia > 1){
			videohtml += '<div class="thecaption"><div class="captioninner">' + countermarkup + (mediafigure[1] || "") + '</div></div>\n'
		}
		videohtml += '</div>'
		return videohtml
	}

	function preloadmedia(mediaurl, callback){
		var callback = callback || function(){}

		if (!isYoutubeReg.test(mediaurl)){ // if image?
			var preload = new Image()
			preload.onload = function(){
				callback()
			}
			preload.onerror = function(){
				callback('error')
			}
			preload.src= mediaurl
		}
		else{ // if youtube video
			callback()
		}
	}

	var responsivegallery = {
		$galleryui: null,
		$galleryinner: null,
		$loadingdiv: null,
		loadingdivtimer: null,
		$errordiv: null,
		$galleryfigurearea: null,
		activesettings: null,
		activegallery: {media:[], curmedia:0, mediashown:[], startingmedia:null},
		
		buildgalleryui: function(){
			this.$galleryui = $(galleryui).appendTo(document.body)
			this.$galleryinner = this.$galleryui.find('div.galleryinner')
			this.$loadingdiv = this.$galleryui.find('div.loadingdiv')
			this.$errordiv = this.$galleryui.find('div.errordiv')
			this.$galleryfigurearea = this.$galleryui.find('div.figurearea')
			var $closebutt = this.$galleryui.find('div.close')
			var $leftnav = this.$galleryui.find('div.leftnav')
			var $rightnav = this.$galleryui.find('div.rightnav')

			$(document).on('keyup', function(e){
				if (responsivegallery.$galleryui.css('display') == 'block'){
					if (e.keyCode == KEYCODE_ESC)
						responsivegallery.hidegallery()
					else if (e.keyCode == KEYCODE_LEFT && responsivegallery.activegallery.media.length > 1)
						responsivegallery.navigate('prev')
					else if (e.keyCode == KEYCODE_RIGHT && responsivegallery.activegallery.media.length > 1)
						responsivegallery.navigate('next')
				}
			})

			this.$galleryui.on('click', function(){
				responsivegallery.hidegallery()
			})

			this.$galleryfigurearea.on('click', function(e){
				e.stopPropagation()
			})

			$leftnav.on('click', function(e){
				responsivegallery.navigate('prev')
				e.stopPropagation()
			})

			$rightnav.on('click', function(e){
				responsivegallery.navigate('next')
				e.stopPropagation()
			})

			$(window).on('resize.adjustuidimensions', function(){
				if (responsivegallery.$galleryui.css('display') == 'block'){
					if (responsivegallery.$galleryfigurearea.hasClass('isvideo')){
						var captionheight = responsivegallery.$galleryinner.find('div.thecaption').height() || 0
						var maxheight = responsivegallery.$galleryinner.height() - captionheight
						var maxwidth = maxheight * videoaspectratio - 30
						if (maxwidth > 1000){ // if video width is past 1000, create some left/right margin inside window
							maxwidth -= 100
						}
						responsivegallery.$galleryfigurearea.css({width: maxwidth})
					}
					else{
						var $galleryimg = responsivegallery.$galleryfigurearea.find('img:eq(0)')
						$galleryimg.css('maxHeight', responsivegallery.$galleryinner.height()-10)
						responsivegallery.$galleryfigurearea.css({width: 'auto'})
					}
				}
			})

			var swipeOptions={ // swipe object variables
				triggerOnTouchEnd : true,
				triggerOnTouchLeave : true,
				fallbackToMouseEvents : false, // enable mouse emulation of swipe navigation in non touch devices?
				swipethreshold: 75,
				excludedElements:[]
			}
	
			swipeOptions.swipeStatus = function(event, phase, direction, distance){
				if (phase == 'end'){
					var navkeyword = /(right)/i.test(direction)? 'prev' : 'next'
					responsivegallery.navigate(navkeyword)
				}
			}

			if (this.$galleryfigurearea.swipe){
				this.$galleryinner.swipe(swipeOptions)
			}

		},

		destroyvideoplayer: function(){
			if (youtubeplayer != null){
				youtubeplayer.destroy()
				youtubeplayer = null
			}
		},

		showgallery: function(){
			var $navbuttons = this.$galleryui.find('div.leftnav, div.rightnav')
			$navbuttons.css('display', (this.activegallery.media.length > 1)? 'block' : 'none')
			this.$galleryui.fadeIn(this.activesettings.fxduration)
		},

		hidegallery:function(){
			this.destroyvideoplayer()
			this.$galleryfigurearea.empty()
			this.$galleryui.fadeOut(this.activesettings.fxduration)
		},

		populategallery: function(){
			var media = this.activegallery.media
			var curmedia = this.activegallery.curmedia
			var targetfigure = media[curmedia]
			clearTimeout( this.loadingdivtimer )
			this.destroyvideoplayer()
			this.loadingdivtimer = setTimeout(function(){
				responsivegallery.$loadingdiv.css('display', 'block')
			}, 50)
			this.$errordiv.css('display', 'none')
			preloadmedia(media[curmedia][0], function(err){
				if (err){
					clearTimeout( responsivegallery.loadingdivtimer )
					responsivegallery.$loadingdiv.css('display', 'none')
					responsivegallery.$galleryfigurearea.empty()
					responsivegallery.$errordiv.css('display', 'block').attr('title', 'Error loading ' + media[curmedia][0])
					var $gallerymedia = responsivegallery.$galleryfigurearea.find('img:eq(0)')
					var $figcaptioninner = responsivegallery.$galleryfigurearea.find('figcaption div.captioninner')
				}
				else{ //  load either media or Youtube video
					var isvideo = isYoutubeReg.test(media[curmedia][0])
					if (isvideo){
						responsivegallery.$galleryfigurearea.addClass('isvideo')
						responsivegallery.$galleryfigurearea.empty().html( buildvideocontainer(media[curmedia], curmedia, media.length) )
						jkyoutubeapidfd.then(function(){
							youtubeplayer = new YT.Player('jkvideotemp', {
								videoId: youTubeIdReg.exec(media[curmedia][0])[3],
								playerVars: { 'autoplay': 1 },
						    events: {
						      'onReady': function(e){
										clearTimeout( responsivegallery.loadingdivtimer )
										responsivegallery.$loadingdiv.css('display', 'none')
									}
								}
							})
						})
					}
					else{
						clearTimeout( responsivegallery.loadingdivtimer )
						responsivegallery.$loadingdiv.css('display', 'none')
						responsivegallery.$galleryfigurearea.removeClass('isvideo')
						responsivegallery.$galleryfigurearea.empty().html( buildfigure(media[curmedia], curmedia, media.length) )
					}
				}
				responsivegallery.$galleryui.css('display', 'block')
				$(window).trigger('resize.adjustuidimensions')
				responsivegallery.$galleryfigurearea.find('figure').css({transitionDuration: (responsivegallery.activesettings.fxduration/1000) + 's', opacity:1})
			})
			

		},

		navigate: function(keyword){
			var media = this.activegallery.media
			var curmedia = this.activegallery.curmedia
			var startingmedia = this.activegallery.startingmedia
			var mediashown = this.activegallery.mediashown

			var targetmedia = (keyword == 'next')? ( (curmedia < media.length-1)? curmedia+1 : 0) :
												(keyword == 'prev')? ( (curmedia > 0)? curmedia-1 : media.length-1) :
												parseInt(keyword)

			if (this.activesettings.autoclose && mediashown[mediashown.length-1] == 'all' && targetmedia == startingmedia){
				this.hidegallery()
				return
			}

			if (jQuery.inArray(targetmedia, mediashown) == -1){
				mediashown.push(targetmedia)
			}
			this.activegallery.curmedia = targetmedia
			this.populategallery()
			if (media.length > 1 && mediashown.length >= media.length && this.activesettings.autoclose){
				mediashown.push('all')
			}
		}

	}

	$.fn.responsivegallery = function(settings){
		var matches = this.length
		var media = []
		return this.each(function(i){
			var s = $.extend({}, defaults, settings)
			var $t = $(this)
			var enlargedmedia
			var $galleryui = $('div.responsivegallery')
			$t.data('pos', i)
			var enlargemediarc = $t.is('a')? $t.attr('href') : $t.find('a:eq(0)').attr('href')
			var caption = ($t.find('div.' + captionclass).length == 1)? $t.find('div.' + captionclass).html() : $t.attr('title')
			enlargedmedia = [enlargemediarc, caption]
			media.push( enlargedmedia ) // add enlargemedia to own collection of media[]
			if (matches == 1){ // if only one thumbnail in collection
				media = media.concat(s.media) // add enlargemedia as 1st element in s.media
			}
			$t.on('click', function(e){
				e.preventDefault()
				responsivegallery.activesettings = s
				responsivegallery.activegallery = {media: media, curmedia: $(this).data('pos'), mediashown: [$(this).data('pos')], startingmedia: $(this).data('pos')}
				responsivegallery.populategallery()
				responsivegallery.showgallery()

			})

			if ($galleryui.length == 0){ // build gallery UI only once
				responsivegallery.buildgalleryui()
			}
			
		}) // end this.each()
	}

})(jQuery);