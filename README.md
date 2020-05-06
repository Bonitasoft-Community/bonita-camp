# Bonita Camp

Bonita Camp is an introduction training to Bonita Community Edition.  
The main objective of this training is to familiarize yourself with concepts and key features of Bonita.  
Bonita Camp include both theoretical knowledge and hands on with exercises that let you build your first Bonita application.
Bonita Camp comes with:

- A set of slides commented in a [series of videos](https://www.youtube.com/playlist?list=PLvvoQatxaHOMHRiP7hFayNXTJNdxIEiYp) (also available in [French](https://www.youtube.com/playlist?list=PLvvoQatxaHOPSATzZe-zPh-LrSNGfpQEf)) or during live sessions
- A set of exercises described on a [dedicated web site](http://bonitasoft-community.github.io/bonita-camp/)
- [Exercises solutions](https://github.com/Bonitasoft-Community/bonita-camp/releases/latest)

If you need assistance you can:

- Ask your question on our dedicated Bonita Camp Slack channel if you have attended a live session
- Ask your question on [Bonitasoft Community forum](https://community.bonitasoft.com/questions-and-answers)
- [Get in touch with Bonitasoft](https://www.bonitasoft.com/contact-us) to get more information about [support offering](https://www.bonitasoft.com/support) and additional features of Enterprise Edition

Content is currently available in:
- English (Bonita Camp 7.10)
- Français (Bonita Camp 7.10)
- Español (Bonita BPM 7.10)


## For Bonita Camp contributors

### Sources

All sources are available on [Bonita Camp GitHub repository](https://github.com/Bonitasoft-Community/bonita-camp/):

- Slides are created using reveal.js and are located in the [slides](https://github.com/Bonitasoft-Community/bonita-camp/tree/master/slides) folder
- Exercises are hosted using GitHub Pages. Source are located in the [docs](https://github.com/Bonitasoft-Community/bonita-camp/tree/master/docs) folder and content is available for users at [http://bonitasoft-community.github.io/bonita-camp/](http://bonitasoft-community.github.io/bonita-camp/)

### Build instructions for slides

1. Download and unzip [reveal.js version 3.8.0](https://github.com/hakimel/reveal.js/releases/tag/3.8.0)
1. Paste the content of the `slides/THE_LANGUAGE/` folder into your `reveal.js` directory
1. Paste the content of the `slides/theme` folder in your `reveal.js/css/theme/source` folder
1. Run `npm install`
1. Run `npm install -g grunt-cli`
1. Run `grunt package`
1. Use the built zip package to share and run the presentation

