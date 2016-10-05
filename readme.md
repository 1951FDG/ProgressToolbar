# ProgressToolbar

ProgressToolbar is a library that adds a compact `Toolbar` widget which contains an animatable `ProgressBar`.

## Readme isn't finished yet, check back shortly.

### Why should I use this library?

You can't directly place a ProgressBar at the bottom of a Toolbar; the Toolbar attempts to position all custom children between the title and th action buttons, resizing the title if necessary. You could just wrap the Toolbar and ProgressBar inside of a `FrameLayout`, but on the cost of performance you'd have to manage the view initialization yourself (`... findViewById() ...`).
This is why I created ProgressToolbar. It does all the heavy work such as modifying the code to position the ProgressBar for you and additionally adds some neat animations for showing/hiding it.



## License

```
Copyright 2016 MrWasdennnoch@xda

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```