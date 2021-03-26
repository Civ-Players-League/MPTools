package com.sixbynine.civ3.mptools.modern

import com.sixbynine.civ3.mptools.modern.ModernResource.ALUMINUM
import com.sixbynine.civ3.mptools.modern.ModernResource.COAL
import com.sixbynine.civ3.mptools.modern.ModernResource.IRON
import com.sixbynine.civ3.mptools.modern.ModernResource.OIL
import com.sixbynine.civ3.mptools.modern.ModernResource.RUBBER
import com.sixbynine.civ3.mptools.modern.ModernResource.SULPHUR
import com.sixbynine.civ3.mptools.modern.ModernResource.URANIUM
import com.sixbynine.civ3.mptools.modern.ModernResource.ZINC
import com.sixbynine.civ3.mptools.resources.strings

enum class ModernUnit(
  val label: String,
  val description: String,
  val resources: List<ModernResource>
) {
  MILITIA(strings.labelMilitia, strings.descMilitia),
  PARTISAN(strings.labelPartisan, strings.descPartisan),
  FLAK(strings.labelFlak, strings.descFlak),
  MOBILE_SAM(strings.labelMobileSam, strings.descMobileSam),
  ARTILLERY(strings.labelArtillery, strings.descArtillery),
  GALLEON(strings.labelGalleon, strings.descGalleon),
  FRIGATE(strings.labelFrigate, strings.descFrigate),
  ATTACK_SUBMARINE(strings.labelAttackSubmarine, strings.descAttackSubmarine, OIL),
  BOMBER(strings.labelBomber, strings.descBomber, OIL),
  HELICOPTER(strings.labelHelicopter, strings.descHelicopter, OIL),
  TRANSPORT(strings.labelTransport, strings.descTransport, OIL),
  CARRIER(strings.labelCarrier, strings.descCarrier, IRON),
  RADAR_ARTILLERY(strings.labelRadarArtillery, strings.descRadarArtillery, IRON),
  IRONCLAD(strings.labelIronclad, strings.descIronclad, IRON),
  MARINE(strings.labelMarine, strings.descMarine, COAL),
  CONVOY(strings.labelConvoy, strings.descConvoy, COAL),
  CRUISER(strings.labelCruiser, strings.descCruiser, COAL),
  INFANTRY(strings.labelInfantry, strings.descInfantry, ZINC),
  SKIRMISHERS(strings.labelSkirmishers, strings.descSkirmishers, RUBBER),
  NUCLEAR_SUBMARINE(strings.labelNuclearSubmarine, strings.descNuclearSubmarine, URANIUM),
  MINI_CRUSE(strings.labelMiniCruise, strings.descMiniCruise, ALUMINUM),
  FIGHTERS(strings.labelFighter, strings.descFighter, SULPHUR),
  MODERN_PARATROOPER(strings.labelModernParatrooper, strings.descModernParatrooper, IRON, ZINC),
  RPG_INFANTRY(strings.labelRpgInfantry, strings.descRpgInfantry, IRON, ALUMINUM),
  POWER_CRUISE(strings.labelPowerCruise, strings.descPowerCruise, IRON, ALUMINUM, SULPHUR),
  AEGIS_CRUISER(strings.labelAegisCruiser, strings.descAegisCruiser, SULPHUR, IRON),
  JET_FIGHTER(strings.labelJetFighter, strings.descJetFighter, OIL, ALUMINUM),
  TANK(strings.labelTank, strings.descTank, ZINC, URANIUM),
  BATTALION(strings.labelBattalion, strings.descBattalion, SULPHUR, URANIUM),
  SPECIAL_FORCES(strings.labelSpecialForces, strings.descSpecialForces, RUBBER, ALUMINUM),
  SUB_CRUISE(strings.labelSubCruise, strings.descSubCruise, COAL, URANIUM),
  DESTROYER(strings.labelDestroyer, strings.descDestroyer, OIL, ZINC),
  CHINOOK(strings.labelChinook, strings.descChinook, IRON, URANIUM),
  FIGHTER_BOMBER(strings.labelFighterBomber, strings.descFighterBomber, OIL, SULPHUR),
  STEALTH_BOMBER(strings.labelStealthBomber, strings.descStealthBomber, OIL, ALUMINUM, SULPHUR),
  MECH_INFANTRY(strings.labelMechInfantry, strings.descMechInfantry, OIL, RUBBER, COAL),
  MODERN_ARMOR(strings.labelModernArmor, strings.descModernArmor, OIL, ALUMINUM, RUBBER),
  COMBAT_ENGINEER(strings.labelCombatEngineer, strings.descCombatEngineer, ZINC, COAL, SULPHUR),
  BATTLESHIP(strings.labelBattleship, strings.descBattleship, OIL, SULPHUR, COAL),
  SUB_CRUISE_PLUS(
    strings.labelSubCruisePlus,
    strings.descSubCruisePlus,
    ZINC,
    RUBBER,
    IRON,
    URANIUM,
    COAL
  ),
  MODERN_ARMOR_PLUS(
    strings.labelModernArmorPlus,
    strings.descModernArmorPlus,
    ALUMINUM,
    RUBBER,
    OIL,
    SULPHUR,
    URANIUM
  ),
  MODERN_PARATROOPER_PLUS(
    strings.labelModernParatrooperPlus,
    strings.descModernParatrooperPlus,
    ALUMINUM,
    COAL,
    IRON,
    SULPHUR,
    ZINC
  ),
  BATTLESHIP_PLUS(
    strings.labelBattleshipPlus,
    strings.descBattleshipPlus,
    OIL,
    ZINC,
    COAL,
    IRON,
    SULPHUR
  );

  constructor(
    label: String,
    description: String,
    vararg resources: ModernResource
  ) : this(label, description, resources.toList())

  val resourcesDescription: String
    get() = resources.map { it.label }.sorted().joinToString(separator = ", ")

  companion object {
    /**
     * Returns the list of units that may be built using [availableResources], sorted
     * alphabetically.
     */
    fun getAvailableUnits(availableResources: Collection<ModernResource>): List<ModernUnit> {
      return values()
        .filter { unit -> unit.resources.all { it in availableResources } }
        .sortedBy { it.label }
    }
  }
}