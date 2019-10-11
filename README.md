# re-frame-native

A [Leiningen](https://leiningen.org/) template for generating a [re-frame](https://github.com/Day8/re-frame) application on [React Native](https://facebook.github.io/react-native/) based on [shadow-cljs](https://github.com/thheller/shadow-cljs) and [lein-shadow](https://gitlab.com/nikperic/lein-shadow) 

## Usage

```shell script 
$ lein new re-frame-native <project-name>
```

See the generated [README.md](./resources/leiningen/new/re_frame_native/README.md) for details on how to use the resulting application

## Credits

This template is based on the work of many others, but in particular: [re-natal](https://github.com/drapanjanas/re-natal).  In fact, this template is more or less identical to the output of running ```re-natal init <project-name>``` but with one key distinction.  Re-natal generates re-frame code using a [figwheel](https://github.com/bhauman/lein-figwheel) based configuration, whereas this template focuses on a [shadow-cljs](https://github.com/thheller/shadow-cljs) based flow.