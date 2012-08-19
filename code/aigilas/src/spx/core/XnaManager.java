package spx.core;import org.newdawn.slick.Image;import xna.wrapper.ContentManager;import xna.wrapper.GraphicsDeviceManager;import xna.wrapper.Resolution;import xna.wrapper.SpriteBatch;import xna.wrapper.SpriteFont;public class XnaManager {	public static int WindowHeight = GameManager.SpriteHeight			* GameManager.TileMapHeight; // 720 //1050	public static int WindowWidth = GameManager.SpriteWidth			* GameManager.TileMapWidth; // 1280 //1680	public static int RenderHeight = WindowHeight;	public static int RenderWidth = WindowWidth;	private static ContentManager __assetHandler;	private static GraphicsDeviceManager __graphics;	public static SpriteBatch Renderer;	private static final String __menuBaseSprite = "MenuBase.png";	private static final String __gameplaySheetSprite = "GameplaySheet.png";	private static final String __gameOverSprite = "GameOver.png";	private static final String __fontName = "Action";	private static final String __particleSprite = "Particle.png";	public static void SetContentManager(ContentManager assetHandler) {		__assetHandler = assetHandler;	}	private static Image GetAsset(String resourceName) {		return __assetHandler.LoadTexture(resourceName);	}	public static Image GetParticleAsset() {		return GetAsset(__particleSprite);	}	public static Image GetMenuBaseAsset() {		return GetAsset(__menuBaseSprite);	}	public static Image GetSpriteAsset() {		return GetAsset(__gameplaySheetSprite);	}	public static Image GetGameOverAsset() {		return GetAsset(__gameOverSprite);	}	private static SpriteFont GetFont(String resourceName) {		return __assetHandler.LoadSpriteFont(resourceName);	}	public static SpriteFont GetActionFont() {		return GetFont(__fontName);	}	public static void SetupCamera(GraphicsDeviceManager graphics,			boolean isFullScreen) {		__graphics = graphics;		Renderer = new SpriteBatch();		GraphicsDeviceManager.PreferredBackBufferHeight = XnaManager.WindowHeight;		GraphicsDeviceManager.PreferredBackBufferWidth = XnaManager.WindowWidth;		__graphics.IsFullScreen = isFullScreen;		__graphics.ApplyChanges();		Resolution.Init(__graphics);		Resolution.SetVirtualResolution(WindowWidth, WindowHeight);		Resolution.SetResolution(RenderWidth, RenderHeight, isFullScreen);	}	public static Point2 GetCenter() {		return new Point2(WindowWidth / 2, WindowHeight / 2);	}	public static Point2 GetDimensions() {		return new Point2(WindowWidth, WindowHeight);	}}