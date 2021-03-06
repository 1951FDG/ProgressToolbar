# ProgressToolbar

[![API](https://img.shields.io/badge/API-16%2B-blue.svg)](https://android-arsenal.com/api?level=16)
[![JitPack](https://img.shields.io/jitpack/v/1951FDG/ProgressToolbar.svg)](https://jitpack.io/#1951FDG/ProgressToolbar)

ProgressToolbar is a library that adds a compact `Toolbar` widget which contains an animatable `ProgressBar`.

### Why should I use this library?

You can't directly place a ProgressBar at the bottom of a Toolbar; the Toolbar attempts to position all custom children between the title and the action buttons, resizing the title if necessary. You could just wrap the Toolbar and ProgressBar inside of a `FrameLayout`, but on the cost of simplicity, you'd have to manage the view initialization (`findViewById()`) and the animations yourself.
This is why I created ProgressToolbar. It does all the heavy work such as modifying the code to position the ProgressBar for you and additionally adds some neat animations for showing/hiding it.

### Sample Project

You can download a sample app of this library [here](https://github.com/1951FDG/ProgressToolbar/releases).

### Integration

This library is available via JitPack. Simply add this to your `build.gradle` file:

```gradle
implementation 'com.github.1951FDG:ProgressToolbar:1.0.9'
```

The `minSdkVersion` is `16`.

The changelog can be found [here](https://github.com/1951FDG/ProgressToolbar/blob/master/changelog.md).

### Usage

The `ProgressToolbar` extends `com.google.android.material.appbar.MaterialToolbar` which means you can replace any Toolbar you previously used with this one (if you are using AppCompat or Material Design Components).
The integrated `ProgressBar` uses the library [MaterialProgressBar](https://github.com/DreaminginCodeZH/MaterialProgressBar) to achieve a consistent Material-like look across all supported Android versions.

```xml
<tk.wasdennnoch.progresstoolbar.ProgressToolbar
    android:id="@+id/toolbar"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"
    android:background="?attr/colorPrimary"/>
```

Available XML tags and Java methods (getters not included):

| Tag / Method                                              | Description                                                              |
| --------------------------------------------------------- | ------------------------------------------------------------------------ |
| `android:tint` / `setProgressTintList(ColorStateList)`    | Apply a tint to the ProgressBar                                          |
| `android:indeterminate` / `setIndeterminate(boolean)`     | Change the indeterminate mode for the ProgressBar                        |
| `android:max` / `setMax(int)`                             | Set the maximum range of the ProgressBar                                 |
| `android:progress` / `setProgress(int)`                   | Set the current progress of the ProgressBar                              |
| `android:secondaryProgress` / `setSecondaryProgress(int)` | Set the current secondary progress of the ProgressBar                    |
| `ptb_progressAtTop` / `setProgressAtTop(boolean)`         | Position the ProgressBar at the top of the Toolbar instead at the bottom |
| `ptb_progressHeight` / `setProgressHeight(boolean)`       | Set the height of the ProgressBar in pixels                              |
| `hideProgress()`                                          | Hide the ProgressBar without animation                                   |
| `hideProgress(boolean)`                                   | Hide the ProgressBar, optionally with animation                          |
| `showProgress()`                                          | Show the ProgressBar without animation                                   |
| `showProgress(boolean)`                                   | Show the ProgressBar, optionally with animation                          |
| `getProgressBar()`                                        | Get the displayed ProgressBar to allow further customization             |
