package Buildings

open class BaseBuildingMaterial() {
    open val numberNeeded: Int = 1
}

class Wood: BaseBuildingMaterial() {
    override val numberNeeded = 4
}

class Brick: BaseBuildingMaterial() {
    override val numberNeeded = 8
}

class Building <T: BaseBuildingMaterial> (val buildingMaterial: T) {

    val baseMaterialNeeded = 100
    val actualMaterialNeeded = (baseMaterialNeeded*buildingMaterial.numberNeeded)

    fun build() {
        println("${actualMaterialNeeded} ${buildingMaterial::class.simpleName} required")
    }
}