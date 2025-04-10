package me.udnek.fnafu.mechanic.door

import me.udnek.fnafu.util.Originable
import me.udnek.fnafu.map.location.LocationSingle
import org.bukkit.*

class DoorButtonPair(val door: Door, val doorButton: DoorButton) : Originable {

    constructor(
        doorX: Long,
        doorY: Long,
        doorZ: Long,
        direction: Door.Direction,
        buttonX: Long,
        buttonY: Long,
        buttonZ: Long
    ) : this(
        Door(LocationSingle(doorX.toDouble(), doorY.toDouble(), doorZ.toDouble()), direction),
        DoorButton(LocationSingle(buttonX.toDouble(), buttonY.toDouble(), buttonZ.toDouble()))
    )

    fun hasButtonAt(location: Location): Boolean {
        val buttonLocation = doorButton.location
        return buttonLocation.blockX == location.blockX && buttonLocation.blockY == location.blockY && buttonLocation.blockZ == location.blockZ
    }

    override fun setOrigin(origin: Location) {
        door.setOrigin(origin)
        doorButton.setOrigin(origin)
    }
}
