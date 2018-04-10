# gdxBytersEngine
Simple game engine for libgdx 

[![](https://jitpack.io/v/BlackDizel/gdxBytersEngine.svg)](https://jitpack.io/#BlackDizel/gdxBytersEngine)
## Features
- screens navigation
- dialog system
- menu
- camera
## Installation
1. Download [libgdx installer app](https://libgdx.badlogicgames.com/download.html)
2. Create project

![setup app gui exmaple](/img/libgdx-setup.png)

3. Add library to gradle dependencies (We use [jitpack.io](https://jitpack.io/))
```gradle
repositories { 
	maven { url "https://jitpack.io" }
	}
dependencies {
	compile 'com.github.BlackDizel:gdxBytersEngine:0.6'
}
```  
4. Run gradle sync _(in IdeaJ 2016.3 right gradle panel, sync button)_.
5. In `core` module replace `Core.java` class content like
```java
public class Core extends ApplicationAdapter {
	
	private Engine engine;

	@Override
	public void create () {
		engine = new Engine();
        	engine.load();
        	engine.getInjector().getNavigator().navigateScreen(new ScreenMain()); //ScreenMain implements IScreen interface
		setColorClear();
	}

	@Override
	public void render () {
		engine.render();
	}
	
	@Override
	public void dispose () {
		engine.dispose();
	}

	public void resize(int width, int height) {
		Engine.getInstance().resize(width, height);
	}

}
```
6. If you use IdeaJ, setup [environment](https://github.com/libgdx/libgdx/wiki/Gradle-and-Intellij-IDEA)
