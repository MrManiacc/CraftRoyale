# CraftRoyale | 0.0.1
A minecraft equivalent of https://clashroyale.com/

#Description
CraftRoyale is a upcoming project that aims to be the next popular pass time for many minecraft players. It's goal is to provide a unique experience similar to that of the [ClashRoyale](https://itunes.apple.com/nz/app/clash-royale/id1053012308?mt=8) app. It is a [Spigot](http://www.spigotmc.org/) plugin. The main aim of this project is to make it simple for server administrators and fun for players. 

# Developers

* [MrManiacc](https://github.com/MrManiacc) - Lead Developer



# Commands and Permissions
### Administrators commands:
* /arena start - start the creation process of an arena
* /arena set **[component]**  - sets the specified **[component]** to the world edit selection
* /arena finish - finish the creation process of an arena

# Arena Component **[component]**
* ENTIRE_SELECTION - component for the entire arena selection. (required)
* RED_SIDE_SELECTION - component for red side selection. (required)
* BLUE_SIDE_SELECTION - component for the blue side selection.  (required)
* RED_KING_TOWER - component for the red king tower.  (required)
* BLUE_KING_TOWER - component for the blue king tower. (required)
* RED_KING_TOWER_STAND - component for the red king's stand inside the king tower. (required)
* BLUE_KING_TOWER_STAND - component for the blue king's stand inside the king tower. (required)
* RED_LEFT_TOWER - component for the red side's left tower. (required)
* BLUE_LEFT_TOWER - component for the blue side's left tower. (required)
* RED_RIGHT_TOWER - component for the red side's right tower. (required)
* BLUE_RIGHT_TOWER - component for the blue side's right tower. (required)
* SPECATOR_SPAWN - component for the spectator spawn. (optional)
* ARENA_LEVEL (level) - component to set arena level from 1 to 8 if not set defaults to 1. (optional)
