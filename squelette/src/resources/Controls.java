package resources;

import libraries.Keybinding;
import libraries.Keybinding.SpecialKeys;

public class Controls
{
	public static int goUp = Keybinding.keycodeOf('z');
	public static int goDown = Keybinding.keycodeOf('s');
	public static int goRight = Keybinding.keycodeOf('d');
	public static int goLeft = Keybinding.keycodeOf('q');
	// for spider
	public static int shoUp = Keybinding.keycodeOf(SpecialKeys.UP);
	public static int shoDown =Keybinding.keycodeOf(SpecialKeys.DOWN);
	public static int shRight = Keybinding.keycodeOf(SpecialKeys.RIGHT);
	public static int shLeft = Keybinding.keycodeOf(SpecialKeys.LEFT);
}
