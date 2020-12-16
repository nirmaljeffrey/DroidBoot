# DroidBoot
DroidBoot makes it easy to production grade Android Jetpack based applications that you can "just run".

 
 ## WHY DROIDBOOT?
   *  Why the features in android are taking more time for development?
   *  Why there is no documentation for features developed in android and implementation for each screen varies from dev to dev?
   *  Why devs are spending more time on bug fixes?
   *  Why code is not unit testable?
   *  Why developers are not able to concentrate on user experience (eg: layout designs, animations)?
   *  Why dependency injection is not used?
   *  Why process death was not handled in most of the places in our existing applications?
  
     
  #### We are proposing droidboot as solution for all the above questions.  DroidBoot is a library/module which will be built on top of android jetpack components and, it will help to reduce bugs and development time spent on an Android feature. More importantly, it will make developers avoid reinventing the wheel while developing a feature. DroidBoot will be at the intersection of MVVM and MVI architecture.DroidBoot will expose APIs at the view layer, ViewModel layer, Repository layer to prevent developers from performing mundane tasks while developing an android feature.
      



## DIAGRAMS TO UNDERSTAND DROIDBOOT'S CORE COMPONENTS AND ITS THEORY
<img src="./droidBoot assets/MVI.jpg">
<img src="./droidBoot assets/droidboot-arch.jpg">
<img src="./droidBoot assets/simple-arch-diagram.jpg">
<img src="./droidBoot assets/complex-arch.jpg">
<img src="./droidBoot assets/statefullayout.jpg">
<img src="./droidBoot assets/events.jpg">
<img src="./droidBoot assets/mvvm-existing.jpg">
<img src="./droidBoot assets/droidboot-smiley.jpg">

## NOTE
   Navigation Sample and stateFulLayout sample and sample project to understand the behaviour of livedata vs livedata with event wrapper vs singleLiveEvent are included in this repo.
   
   

## SIMILAR LIBRARIES
* [AIRBNB'S MVRX](https://github.com/airbnb/MvRx)
* [SPOTIFY'S MOBIUS](https://github.com/spotify/mobius)
* [TINDER'S STATEMACHINE](https://github.com/Tinder/StateMachine)
* [SQUARE'S WORKFLOW](https://github.com/square/workflow)
* [FREELETIC'S RXREDUX](https://github.com/freeletics/RxRedux)
* [RAINBOWCAKE](https://rainbowcake.dev/)
* [MOBSY](https://github.com/sockeqwe/mosby)
* [UNIFLOW](https://github.com/uniflow-kt/uniflow-kt)
* [MVICORE](https://github.com/badoo/MVICore)
* [ORBIT MVI](https://github.com/babylonhealth/orbit-mvi)
* [ROXIE](https://github.com/ww-tech/roxie)
* [EIFFEL](https://github.com/etiennelenhart/Eiffel)

## PROS:
 * Kotlin multiplatform will be based on MVI/Unidirectional Data flow/Redux and it will be the future.
 refer - [Future of apps](https://danielebaroncelli.medium.com/the-future-of-apps-declarative-uis-with-kotlin-multiplatform-d-kmp-part-1-3-c0e1530a5343)
 
## REFERENCES:
* [Architecting Android and iOS app features for 2020 - Kaushik Gopal](https://youtu.be/BdGVCsHj2vU)
* [Managing State with RxJava by Jake Wharton](https://youtu.be/0IKHxjkgop4)
* [Márton Braun - Handling View State and Events with RainbowCake](https://youtu.be/4U7hxKAZ7qE)
* [MODEL VIEW INTENT IN ANDROID](http://hannesdorfmann.com/android/model-view-intent)
* [Thoughts about Event Handling on Android](https://zsmb.co/thoughts-about-event-handling-on-android/)
* [Thoughts about State Handling on Android](https://zsmb.co/thoughts-about-state-handling-on-android/)
* [Designing and Working with Single View States on Android](https://zsmb.co/designing-and-working-with-single-view-states-on-android/)
* [Gabriel Peal - MvRx: Android Development on Autopilot](https://youtu.be/Web4xPi2Ga4)
* [KotlinConf 2018 - Sealed Classes Opened My Mind: How We Use Kotlin to Tame State at Etsy by Patrick](https://youtu.be/uGMm3StjqLI)
* [KotlinConf 2018 - Representing State: the Kotlin Edition by Christina Lee](https://youtu.be/-lVVfxsRjcY)
* [Design for errors - An introduction to Domain Modeling with a bit of Arrow by Ivan Morgillo](https://youtu.be/1pEffDww4-Q)
* [bufferapp-android-clean-architecture-mvi-boilerplate](https://github.com/bufferapp/android-clean-architecture-mvi-boilerplate)
* [Do you even map though? Data model mapping in Android Apps](https://buffer.com/resources/even-map-though-data-model-mapping-android-apps/)
* [A quick story about async callbacks, memory leaks, WeakReferences, and misconceptions](https://proandroiddev.com/a-quick-story-about-async-callbacks-memory-leaks-weakreferences-and-misconceptions-78003b3d6b26)
* [Anemic Repositories, MVI and RxJava-induced design damage, and how AAC ViewModel is silently killing your app](https://proandroiddev.com/anemic-repositories-mvi-and-rxjava-induced-design-damage-and-how-aac-viewmodel-is-silently-1762caa70e13)
