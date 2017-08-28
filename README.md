# gdxBytersEngine
Simple game engine for libgdx 
## Features
- screens navigation
- dialog system
- menus
- camera
## Installation (v0.1)
1. Download [libgdx installer app](https://libgdx.badlogicgames.com/download.html)
2. Create project

![setup app gui exmaple](/img/libgdx-setup.png)

3. Navigate to project dir
4. Run
```sh
git init
git submodule add https://github.com/BlackDizel/gdxBytersEngine coreEngine
```
5. In project `settings.gradle` file add `coreEngine` module link like
```groovy
include 'desktop', 'core', 'coreEngine'
```
6. In project `build.gradle` add link to coreEngine module in `core` section
```groovy
project(":core") {
    apply plugin: "java"

    dependencies {
        compile project(':coreEngine')
        compile "com.badlogicgames.gdx:gdx:$gdxVersion"
    }
}
```
7. Run gradle sync _(in IdeaJ 2016.3 right gradle panel, sync button)_.
8. In `core` module replace `Core.java` class content like
```java
public class Core extends ApplicationAdapter {

	@Override
	public void create () {
		Engine.getInstance().create(new ScreenMenu());
		setColorClear();
	}


	private void setColorClear() {
		Color colorClear = new Color();
		colorClear.r = 0.1f;
		colorClear.g = 0.1f;
		colorClear.b = 0.1f;
		colorClear.a = 1f;
		Engine.getInstance().setColorClear(colorClear);
	}


	@Override
	public void render () {
		Engine.getInstance().render();
	}
	
	@Override
	public void dispose () {
		Engine.getInstance().dispose();
	}

	public void resize(int width, int height) {
		Engine.getInstance().resize(width, height);
	}

}
```
9. If you use IdeaJ, setup [environment](https://github.com/libgdx/libgdx/wiki/Gradle-and-Intellij-IDEA)
