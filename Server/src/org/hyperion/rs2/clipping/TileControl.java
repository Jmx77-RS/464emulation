package org.hyperion.rs2.clipping;

import java.util.HashMap;

import org.hyperion.rs2.model.Location;
import org.hyperion.rs2.model.Mob;
import org.hyperion.rs2.model.NPC;
import org.hyperion.rs2.model.World;
import org.hyperion.rs2.model.region.Region;

public class TileControl {
    private static TileControl singleton = null;

    private HashMap<Mob, Location[]> occupiedLocations = new HashMap<Mob, Location[]>();

    public static TileControl getSingleton() {
        if (singleton == null) {
            singleton = new TileControl();
        }
        return singleton;
    }

    public static Location[] getHoveringTiles(Mob mob) {
        return getHoveringTiles(mob, mob.getLocation());
    }

    public static Location[] getHoveringTiles(Mob mob, Location location) {
        int buf = 1;
        int offset = 0;
        if (mob.isNPC()) {
            buf = ((NPC) mob).getDefinition().getSize();
        }
        Location[] locations = new Location[buf * buf];
        if (locations.length == 1)
            locations[offset] = location;
        else {
            for (int x = 0; x < buf; x++) {
                for (int y = 0; y < buf; y++) {
                    locations[(offset++)] = Location.create(location.getX() + x, location.getY() + y, location.getZ());
                }
            }
        }
        return locations;
    }

    public static int calculateDistance(Mob mobA, Mob mobB) {
        Location[] pointsA = getHoveringTiles(mobA);
        Location[] pointsB = getHoveringTiles(mobB);

        int lowestCount = 16;
        int distance = 16;

        for (Location pointA : pointsA) {
            for (Location pointB : pointsB) {
                if (pointA.equals(pointB)) {
                    return 0;
                }
                distance = calculateDistance(pointA, pointB);
                if (distance < lowestCount) {
                    lowestCount = distance;
                }
            }
        }

        return lowestCount;
    }

    public static int calculateDistance(Location pointA, Location pointB) {
        int offsetX = Math.abs(pointA.getX() - pointB.getX());
        int offsetY = Math.abs(pointA.getY() - pointB.getY());
        return offsetX > offsetY ? offsetX : offsetY;
    }

    public Location[] getOccupiedLocations(Mob mob) {
        return this.occupiedLocations.get(mob);
    }

    public void setOccupiedLocation(Mob mob, Location[] locations) {
        if ((mob == null) || (locations == null))
            return;
        this.occupiedLocations.remove(mob);
        this.occupiedLocations.put(mob, locations);
    }

    public boolean locationOccupied(Location[] locations, Mob mob) {
        if ((locations == null) || (mob == null))
            return true;
        Location[] npcLocations = null;
        for (Region r : World.getWorld().getRegionManager().getSurroundingRegions(mob.getLocation())) {
            for (NPC npc : r.getNpcs()) {
                if ((mob.isNPC()) && ((npc == null) || (npc == mob))) {
                    continue;
                }
                npcLocations = getOccupiedLocations(npc);
                if (npcLocations != null) {
                    for (Location loc : locations) {
                        for (Location loc2 : npcLocations) {
                            if (loc.equals(loc2)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}