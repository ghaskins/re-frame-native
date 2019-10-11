# {{name}}

A clojurescript application for [React Native](https://facebook.github.io/react-native/) based on [re-frame](https://github.com/Day8/re-frame)
 
## Prerequsites

You will need a [React Native environment](https://facebook.github.io/react-native/docs/getting-started)

e.g.
```shell script
npm install -g react-native-cli
``` 
 
## Usage
 
### Development

In one terminal, run

```shell script 
lein shadow watch app
```

#### iOS

If this is the first time running the app, you may also need to run

```shell script
cd ios && pod install
```

Lastly, run

```shell script
react-native run-ios
```

#### Android

TBD

#### Tips

If you add new npm deps to project.clj, you may need to run

```shell script
lein shadow watch/release/compile app
react-native link
```

to ensure the new dependencies are downloaded and linked in your app properly

#### Release

Create a release bundle

```shell script
lein shadow release app
```

And then use something like [fastlane](https://fastlane.tools/) or XCode to create a final deployment artifact