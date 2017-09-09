# gdxBytersEngine
Simple game engine for libgdx 

[![](https://jitpack.io/v/BlackDizel/gdxBytersEngine.svg)](https://jitpack.io/#BlackDizel/gdxBytersEngine)
## Features
- screens navigation
- dialog system
- menus
- camera
## Installation (v0.1)
1. Download [libgdx installer app](https://libgdx.badlogicgames.com/download.html)
2. Create project

![setup app gui exmaple](/img/libgdx-setup.png)

3. Add library to gradle dependencies (We use [jitpack.io](https://jitpack.io/))
```gradle
repositories { 
	jcenter()
		maven { url "https://jitpack.io" }
	}
dependencies {
	compile 'com.github.BlackDizel:gdxBytersEngine:0.2'
}
```  
4. Run gradle sync _(in IdeaJ 2016.3 right gradle panel, sync button)_.
5. In `core` module replace `Core.java` class content like
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
6. If you use IdeaJ, setup [environment](https://github.com/libgdx/libgdx/wiki/Gradle-and-Intellij-IDEA)
