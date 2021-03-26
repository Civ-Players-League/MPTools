package com.sixbynine.civ3.mptools.modern

enum class ModernResource {
  ALUMINUM, COAL, IRON, OIL, RUBBER, SULPHUR, URANIUM, ZINC;

  /**
   * Returns the readable label to display for the resource. This works as long as names are single
   * words and we don't need to support translations.
   */
  val label: String
    get() = name[0].toString() + name.substring(1).toLowerCase()
}