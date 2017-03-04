// Copyright (c) 2016 PSForever.net to present
package net.psforever.packet.game.objectcreate

import scodec.{Attempt, Codec, Err}
import scodec.codecs._

import scala.annotation.switch

/**
  * A reference between all object class codes and the name of the object they represent.<br>
  * <br>
  * Object classes compose a number between 0 and (probably) 2047, always translating into an 11-bit value.
  * They are recorded as little-endian hexadecimal values here.
  * In `scodec` terms, that's a `uintL(11)` or `uintL(0xB)`.
  */
object ObjectClass {
  //character
  final val avatar = 0x79 // 121
  //ammunition
  final val bullet_105mm = 0
  final val bullet_12mm = 3
  final val bullet_150mm = 6
  final val bullet_15mm = 9
  final val bullet_20mm = 16
  final val bullet_25mm = 19
  final val bullet_35mm = 21
  final val bullet_75mm = 25
  final val bullet_9mm = 28
  final val bullet_9mm_AP = 29
  final val ancient_ammo_combo = 50
  final val ancient_ammo_vehicle = 51
  final val anniversary_ammo = 54
  final val aphelion_immolation_cannon_ammo = 86
  final val aphelion_laser_ammo = 89
  final val aphelion_plasma_rocket_ammo = 97
  final val aphelion_ppa_ammo = 101
  final val aphelion_starfire_ammo = 106
  final val armor_canister = 111
  final val armor_siphon_ammo = 112
  final val bolt = 145
  final val burster_ammo = 154
  final val colossus_100mm_cannon_ammo = 180
  final val colossus_burster_ammo = 186
  final val colossus_chaingun_ammo = 191
  final val colossus_cluster_bomb_ammo = 195
  final val colossus_tank_cannon_ammo = 205
  final val comet_ammo = 209
  final val dualcycler_ammo = 265
  final val energy_cell = 272
  final val energy_gun_ammo = 275
  final val falcon_ammo = 285
  final val firebird_missile = 287
  final val flamethrower_ammo = 300
  final val flux_cannon_thresher_battery = 307
  final val fluxpod_ammo = 310
  final val frag_cartridge = 327
  final val frag_grenade_ammo = 331
  final val gauss_cannon_ammo = 347
  final val grenade = 370
  final val health_canister = 389
  final val heavy_grenade_mortar = 391
  final val heavy_rail_beam_battery = 393
  final val hellfire_ammo = 399
  final val hunter_seeker_missile = 403
  final val jammer_cartridge = 413
  final val jammer_grenade_ammo = 417
  final val lancer_cartridge = 426
  final val liberator_bomb = 434
  final val maelstrom_ammo = 463
  final val melee_ammo = 540
  final val mine = 550
  final val mine_sweeper_ammo = 553
  final val ntu_siphon_ammo = 595
  final val oicw_ammo = 600
  final val pellet_gun_ammo = 630
  final val peregrine_dual_machine_gun_ammo = 637
  final val peregrine_mechhammer_ammo = 645
  final val peregrine_particle_cannon_ammo = 653
  final val peregrine_rocket_pod_ammo = 656
  final val peregrine_sparrow_ammo = 659
  final val phalanx_ammo = 664
  final val phoenix_missile = 674
  final val plasma_cartridge = 677
  final val plasma_grenade_ammo = 681
  final val pounder_ammo = 693
  final val pulse_battery = 704
  final val quasar_ammo = 712
  final val reaver_rocket = 722
  final val rocket = 734
  final val scattercannon_ammo = 745
  final val shotgun_shell = 755
  final val shotgun_shell_AP = 756
  final val six_shooter_ammo = 762
  final val skyguard_flak_cannon_ammo = 786
  final val sparrow_ammo = 791
  final val spitfire_aa_ammo = 820
  final val spitfire_ammo = 823
  final val starfire_ammo = 830
  final val striker_missile_ammo = 839
  final val trek_ammo = 877
  final val upgrade_canister = 922
  final val wasp_gun_ammo = 998
  final val wasp_rocket_ammo = 1000
  final val winchester_ammo = 1004
  //weapons
  final val chaingun_12mm = 2
  final val chaingun_15mm = 8
  final val cannon_20mm = 12
  final val cannon_deliverer_20mm = 13
  final val cannon_dropship_20mm = 14
  final val cannon_dropship_l_20mm = 15
  final val cannon_75mm = 23
  final val lightning_75mm = 24
  final val ace = 32
  final val ace_deployable = 33
  final val advanced_ace = 39
  final val advanced_missile_launcher_t = 40
  final val anniversary_gun = 55
  final val anniversary_guna = 56
  final val anniversary_gunb = 57
  final val apc_ballgun_l = 63
  final val apc_ballgun_r = 64
  final val apc_weapon_systema = 69
  final val apc_weapon_systemb = 70
  final val apc_weapon_systemc = 71
  final val apc_weapon_systemc_nc = 72
  final val apc_weapon_systemc_tr = 73
  final val apc_weapon_systemc_vs = 74
  final val apc_weapon_systemd = 75
  final val apc_weapon_systemd_nc = 76
  final val apc_weapon_systemd_tr = 77
  final val apc_weapon_systemd_vs = 78
  final val aphelion_immolation_cannon = 85
  final val aphelion_laser = 88
  final val aphelion_laser_left = 90
  final val aphelion_laser_right = 92
  final val aphelion_plasma_rocket_pod = 98
  final val aphelion_ppa = 100
  final val aphelion_ppa_left = 102
  final val aphelion_ppa_right = 104
  final val aphelion_starfire = 105
  final val aphelion_starfire_left = 107
  final val aphelion_starfire_right = 109
  final val aurora_weapon_systema = 119
  final val aurora_weapon_systemb = 120
  final val battlewagon_weapon_systema = 136
  final val battlewagon_weapon_systemb = 137
  final val battlewagon_weapon_systemc = 138
  final val battlewagon_weapon_systemd = 139
  final val beamer = 140
  final val bolt_driver = 146
  final val chainblade = 175
  final val chaingun_p = 177
  final val colossus_burster = 185
  final val colossus_burster_left = 187
  final val colossus_burster_right = 189
  final val colossus_chaingun = 190
  final val colossus_chaingun_left = 192
  final val colossus_chaingun_right = 194
  final val colossus_cluster_bomb_pod = 196
  final val colossus_dual_100mm_cannons = 198
  final val colossus_tank_cannon = 204
  final val colossus_tank_cannon_left = 206
  final val colossus_tank_cannon_right = 208
  final val cycler = 233
  final val cycler_v2 = 234
  final val cycler_v3 = 235
  final val cycler_v4 = 236
  final val dropship_rear_turret = 262
  final val energy_gun = 274
  final val energy_gun_nc = 276
  final val energy_gun_tr = 278
  final val energy_gun_vs = 280
  final val flail_weapon = 298
  final val flamethrower = 299
  final val flechette = 304
  final val flux_cannon_thresher = 306
  final val fluxpod = 309
  final val forceblade = 324
  final val fragmentation_grenade = 334
  final val fury_weapon_systema = 336
  final val galaxy_gunship_cannon = 339
  final val galaxy_gunship_gun = 340
  final val galaxy_gunship_tailgun = 342
  final val gauss = 345
  final val gauss_cannon = 346
  final val grenade_launcher_marauder = 371
  final val heavy_rail_beam_magrider = 394
  final val heavy_sniper = 396
  final val hellfire = 398
  final val hunterseeker = 406
  final val ilc9 = 407
  final val isp = 411
  final val katana = 421
  final val lancer = 425
  final val lasher = 429
  final val liberator_25mm_cannon = 433
  final val liberator_bomb_bay = 435
  final val liberator_weapon_system = 440
  final val lightgunship_weapon_system = 445
  final val lightning_weapon_system = 448
  final val maelstrom = 462
  final val magcutter = 468
  final val mediumtransport_weapon_systemA = 534
  final val mediumtransport_weapon_systemB = 535
  final val mini_chaingun = 556
  final val oicw = 599
  final val particle_beam_magrider = 628
  final val pellet_gun = 629
  final val peregrine_dual_machine_gun = 636
  final val peregrine_dual_machine_gun_left = 638
  final val peregrine_dual_machine_gun_right = 640
  final val peregrine_dual_rocket_pods = 641
  final val peregrine_mechhammer = 644
  final val peregrine_mechhammer_left = 646
  final val peregrine_mechhammer_right = 648
  final val peregrine_particle_cannon = 652
  final val peregrine_sparrow = 658
  final val peregrine_sparrow_left = 660
  final val peregrine_sparrow_right = 662
  final val phalanx_avcombo = 666
  final val phalanx_flakcombo = 668
  final val phalanx_sgl_hevgatcan = 670
  final val phantasm_12mm_machinegun = 672
  final val phoenix = 673
  final val prowler_weapon_systemA = 699
  final val prowler_weapon_systemB = 700
  final val pulsar = 701
  final val pulsed_particle_accelerator = 705
  final val punisher = 706
  final val quadassault_weapon_system = 709
  final val r_shotgun = 714
  final val radiator = 716
  final val repeater = 730
  final val rocklet = 737
  final val rotarychaingun_mosquito = 740
  final val router_telepad = 743
  final val scythe = 747
  final val six_shooter = 761
  final val skyguard_weapon_system = 788
  final val spiker = 817
  final val spitfire_aa_weapon = 822
  final val spitfire_weapon = 827
  final val striker = 838
  final val suppressor = 845
  final val thumper = 864
  final val thunderer_weapon_systema = 866
  final val thunderer_weapon_systemb = 867
  final val vanguard_weapon_system = 927
  final val vanu_sentry_turret_weapon = 945
  final val vulture_bomb_bay = 987
  final val vulture_nose_weapon_system = 990
  final val vulture_tail_cannon = 992
  final val wasp_weapon_system = 1002
  final val winchester = 1003
  final val dynomite = 267
  final val frag_grenade = 330
  final val generic_grenade = 354
  final val jammer_grenade = 416
  final val mine_sweeper = 552
  final val plasma_grenade = 680
  //tools - medkits
  final val medkit = 536
  final val super_armorkit = 842
  final val super_medkit = 843
  final val super_staminakit = 844
  final val remote_electronics_kit = 728
  final val trek = 876
  final val applicator = 110
  final val medicalapplicator = 531
  final val bank = 132
  final val nano_dispenser = 577
  final val command_detonater = 213
  //unknown
  final val locker_container = 456 //strange item found in inventory slot #5, between holsters and grid



  //TODO refactor this function into another object later
  /**
    * Given an object class, retrieve the `Codec` used to parse and translate the constructor data for that type.<br>
    * <br>
    * This function serves as a giant `switch` statement that loosely connects object data to object class.
    * All entries, save the default, merely point to the `Codec` of pattern `ConstructorData.genericPattern`.
    * This pattern connects all `Codec`s back to the superclass `ConstructorData`.
    * The default case is a failure case for trying to either decode or encode an unknown class of object.
    * @param objClass the code for the type of object being constructed
    * @return the `Codec` that handles the format of data for that particular item class, or a failing `Codec`
    */
  def selectDataCodec(objClass : Int) : Codec[ConstructorData.genericPattern] = {
    (objClass : @switch) match {
      //ammunition
      case ObjectClass.bullet_105mm => AmmoBoxData.genericCodec
      case ObjectClass.bullet_12mm => AmmoBoxData.genericCodec
      case ObjectClass.bullet_150mm => AmmoBoxData.genericCodec
      case ObjectClass.bullet_15mm => AmmoBoxData.genericCodec
      case ObjectClass.bullet_20mm => AmmoBoxData.genericCodec
      case ObjectClass.bullet_25mm => AmmoBoxData.genericCodec
      case ObjectClass.bullet_35mm => AmmoBoxData.genericCodec
      case ObjectClass.bullet_75mm => AmmoBoxData.genericCodec
      case ObjectClass.bullet_9mm => AmmoBoxData.genericCodec
      case ObjectClass.bullet_9mm_AP => AmmoBoxData.genericCodec
      case ObjectClass.ancient_ammo_combo => AmmoBoxData.genericCodec
      case ObjectClass.ancient_ammo_vehicle => AmmoBoxData.genericCodec
      case ObjectClass.anniversary_ammo => AmmoBoxData.genericCodec
      case ObjectClass.aphelion_immolation_cannon_ammo => AmmoBoxData.genericCodec
      case ObjectClass.aphelion_laser_ammo => AmmoBoxData.genericCodec
      case ObjectClass.aphelion_plasma_rocket_ammo => AmmoBoxData.genericCodec
      case ObjectClass.aphelion_ppa_ammo => AmmoBoxData.genericCodec
      case ObjectClass.aphelion_starfire_ammo => AmmoBoxData.genericCodec
      case ObjectClass.armor_canister => AmmoBoxData.genericCodec
      case ObjectClass.armor_siphon_ammo => AmmoBoxData.genericCodec
      case ObjectClass.bolt => AmmoBoxData.genericCodec
      case ObjectClass.burster_ammo => AmmoBoxData.genericCodec
      case ObjectClass.colossus_100mm_cannon_ammo => AmmoBoxData.genericCodec
      case ObjectClass.colossus_burster_ammo => AmmoBoxData.genericCodec
      case ObjectClass.colossus_chaingun_ammo => AmmoBoxData.genericCodec
      case ObjectClass.colossus_cluster_bomb_ammo => AmmoBoxData.genericCodec
      case ObjectClass.colossus_tank_cannon_ammo => AmmoBoxData.genericCodec
      case ObjectClass.comet_ammo => AmmoBoxData.genericCodec
      case ObjectClass.dualcycler_ammo => AmmoBoxData.genericCodec
      case ObjectClass.energy_cell => AmmoBoxData.genericCodec
      case ObjectClass.energy_gun_ammo => AmmoBoxData.genericCodec
      case ObjectClass.falcon_ammo => AmmoBoxData.genericCodec
      case ObjectClass.firebird_missile => AmmoBoxData.genericCodec
      case ObjectClass.flamethrower_ammo => AmmoBoxData.genericCodec
      case ObjectClass.flux_cannon_thresher_battery => AmmoBoxData.genericCodec
      case ObjectClass.fluxpod_ammo => AmmoBoxData.genericCodec
      case ObjectClass.frag_cartridge => AmmoBoxData.genericCodec
      case ObjectClass.frag_grenade_ammo => AmmoBoxData.genericCodec
      case ObjectClass.gauss_cannon_ammo => AmmoBoxData.genericCodec
      case ObjectClass.grenade => AmmoBoxData.genericCodec
      case ObjectClass.health_canister => AmmoBoxData.genericCodec
      case ObjectClass.heavy_grenade_mortar => AmmoBoxData.genericCodec
      case ObjectClass.heavy_rail_beam_battery => AmmoBoxData.genericCodec
      case ObjectClass.hellfire_ammo => AmmoBoxData.genericCodec
      case ObjectClass.hunter_seeker_missile => AmmoBoxData.genericCodec
      case ObjectClass.jammer_cartridge => AmmoBoxData.genericCodec
      case ObjectClass.jammer_grenade_ammo => AmmoBoxData.genericCodec
      case ObjectClass.lancer_cartridge => AmmoBoxData.genericCodec
      case ObjectClass.liberator_bomb => AmmoBoxData.genericCodec
      case ObjectClass.maelstrom_ammo => AmmoBoxData.genericCodec
      case ObjectClass.melee_ammo => AmmoBoxData.genericCodec
      case ObjectClass.mine => AmmoBoxData.genericCodec
      case ObjectClass.mine_sweeper_ammo => AmmoBoxData.genericCodec
      case ObjectClass.ntu_siphon_ammo => AmmoBoxData.genericCodec
      case ObjectClass.oicw_ammo => AmmoBoxData.genericCodec
      case ObjectClass.pellet_gun_ammo => AmmoBoxData.genericCodec
      case ObjectClass.peregrine_dual_machine_gun_ammo => AmmoBoxData.genericCodec
      case ObjectClass.peregrine_mechhammer_ammo => AmmoBoxData.genericCodec
      case ObjectClass.peregrine_particle_cannon_ammo => AmmoBoxData.genericCodec
      case ObjectClass.peregrine_rocket_pod_ammo => AmmoBoxData.genericCodec
      case ObjectClass.peregrine_sparrow_ammo => AmmoBoxData.genericCodec
      case ObjectClass.phalanx_ammo => AmmoBoxData.genericCodec
      case ObjectClass.phoenix_missile => AmmoBoxData.genericCodec
      case ObjectClass.plasma_cartridge => AmmoBoxData.genericCodec
      case ObjectClass.plasma_grenade_ammo => AmmoBoxData.genericCodec
      case ObjectClass.pounder_ammo => AmmoBoxData.genericCodec
      case ObjectClass.pulse_battery => AmmoBoxData.genericCodec
      case ObjectClass.quasar_ammo => AmmoBoxData.genericCodec
      case ObjectClass.reaver_rocket => AmmoBoxData.genericCodec
      case ObjectClass.rocket => AmmoBoxData.genericCodec
      case ObjectClass.scattercannon_ammo => AmmoBoxData.genericCodec
      case ObjectClass.shotgun_shell => AmmoBoxData.genericCodec
      case ObjectClass.shotgun_shell_AP => AmmoBoxData.genericCodec
      case ObjectClass.six_shooter_ammo => AmmoBoxData.genericCodec
      case ObjectClass.skyguard_flak_cannon_ammo => AmmoBoxData.genericCodec
      case ObjectClass.sparrow_ammo => AmmoBoxData.genericCodec
      case ObjectClass.spitfire_aa_ammo => AmmoBoxData.genericCodec
      case ObjectClass.spitfire_ammo => AmmoBoxData.genericCodec
      case ObjectClass.starfire_ammo => AmmoBoxData.genericCodec
      case ObjectClass.striker_missile_ammo => AmmoBoxData.genericCodec
      case ObjectClass.trek_ammo => AmmoBoxData.genericCodec
      case ObjectClass.upgrade_canister => AmmoBoxData.genericCodec
      case ObjectClass.wasp_gun_ammo => AmmoBoxData.genericCodec
      case ObjectClass.wasp_rocket_ammo => AmmoBoxData.genericCodec
      case ObjectClass.winchester_ammo => AmmoBoxData.genericCodec
      //weapons (have a look on punisher)
      case ObjectClass.beamer => WeaponData.genericCodec
      case ObjectClass.chaingun_12mm => WeaponData.genericCodec
      case ObjectClass.chaingun_15mm => WeaponData.genericCodec
      case ObjectClass.cannon_20mm => WeaponData.genericCodec
      case ObjectClass.cannon_deliverer_20mm => WeaponData.genericCodec
      case ObjectClass.cannon_dropship_20mm => WeaponData.genericCodec
      case ObjectClass.cannon_dropship_l_20mm => WeaponData.genericCodec
      case ObjectClass.cannon_75mm => WeaponData.genericCodec
      case ObjectClass.lightning_75mm => WeaponData.genericCodec
      case ObjectClass.ace => WeaponData.genericCodec
      case ObjectClass.ace_deployable => WeaponData.genericCodec
      case ObjectClass.advanced_ace => WeaponData.genericCodec
      case ObjectClass.advanced_missile_launcher_t => WeaponData.genericCodec
      case ObjectClass.anniversary_gun => WeaponData.genericCodec
      case ObjectClass.anniversary_guna => WeaponData.genericCodec
      case ObjectClass.anniversary_gunb => WeaponData.genericCodec
      case ObjectClass.apc_ballgun_l => WeaponData.genericCodec
      case ObjectClass.apc_ballgun_r => WeaponData.genericCodec
      case ObjectClass.apc_weapon_systema => WeaponData.genericCodec
      case ObjectClass.apc_weapon_systemb => WeaponData.genericCodec
      case ObjectClass.apc_weapon_systemc => WeaponData.genericCodec
      case ObjectClass.apc_weapon_systemc_nc => WeaponData.genericCodec
      case ObjectClass.apc_weapon_systemc_tr => WeaponData.genericCodec
      case ObjectClass.apc_weapon_systemc_vs => WeaponData.genericCodec
      case ObjectClass.apc_weapon_systemd => WeaponData.genericCodec
      case ObjectClass.apc_weapon_systemd_nc => WeaponData.genericCodec
      case ObjectClass.apc_weapon_systemd_tr => WeaponData.genericCodec
      case ObjectClass.apc_weapon_systemd_vs => WeaponData.genericCodec
      case ObjectClass.aphelion_immolation_cannon => WeaponData.genericCodec
      case ObjectClass.aphelion_laser => WeaponData.genericCodec
      case ObjectClass.aphelion_laser_left => WeaponData.genericCodec
      case ObjectClass.aphelion_laser_right => WeaponData.genericCodec
      case ObjectClass.aphelion_plasma_rocket_pod => WeaponData.genericCodec
      case ObjectClass.aphelion_ppa => WeaponData.genericCodec
      case ObjectClass.aphelion_ppa_left => WeaponData.genericCodec
      case ObjectClass.aphelion_ppa_right => WeaponData.genericCodec
      case ObjectClass.aphelion_starfire => WeaponData.genericCodec
      case ObjectClass.aphelion_starfire_left => WeaponData.genericCodec
      case ObjectClass.aphelion_starfire_right => WeaponData.genericCodec
      case ObjectClass.aurora_weapon_systema => WeaponData.genericCodec
      case ObjectClass.aurora_weapon_systemb => WeaponData.genericCodec
      case ObjectClass.battlewagon_weapon_systema => WeaponData.genericCodec
      case ObjectClass.battlewagon_weapon_systemb => WeaponData.genericCodec
      case ObjectClass.battlewagon_weapon_systemc => WeaponData.genericCodec
      case ObjectClass.battlewagon_weapon_systemd => WeaponData.genericCodec
      case ObjectClass.bolt_driver => WeaponData.genericCodec
      case ObjectClass.chainblade => WeaponData.genericCodec
      case ObjectClass.chaingun_p => WeaponData.genericCodec
      case ObjectClass.colossus_burster => WeaponData.genericCodec
      case ObjectClass.colossus_burster_left => WeaponData.genericCodec
      case ObjectClass.colossus_burster_right => WeaponData.genericCodec
      case ObjectClass.colossus_chaingun => WeaponData.genericCodec
      case ObjectClass.colossus_chaingun_left => WeaponData.genericCodec
      case ObjectClass.colossus_chaingun_right => WeaponData.genericCodec
      case ObjectClass.colossus_cluster_bomb_pod => WeaponData.genericCodec
      case ObjectClass.colossus_dual_100mm_cannons => WeaponData.genericCodec
      case ObjectClass.colossus_tank_cannon => WeaponData.genericCodec
      case ObjectClass.colossus_tank_cannon_left => WeaponData.genericCodec
      case ObjectClass.colossus_tank_cannon_right => WeaponData.genericCodec
      case ObjectClass.cycler => WeaponData.genericCodec
      case ObjectClass.cycler_v2 => WeaponData.genericCodec
      case ObjectClass.cycler_v3 => WeaponData.genericCodec
      case ObjectClass.cycler_v4 => WeaponData.genericCodec
      case ObjectClass.dropship_rear_turret => WeaponData.genericCodec
      case ObjectClass.energy_gun => WeaponData.genericCodec
      case ObjectClass.energy_gun_nc => WeaponData.genericCodec
      case ObjectClass.energy_gun_tr => WeaponData.genericCodec
      case ObjectClass.energy_gun_vs => WeaponData.genericCodec
      case ObjectClass.flail_weapon => WeaponData.genericCodec
      case ObjectClass.flamethrower => WeaponData.genericCodec
      case ObjectClass.flechette => WeaponData.genericCodec
      case ObjectClass.flux_cannon_thresher => WeaponData.genericCodec
      case ObjectClass.fluxpod => WeaponData.genericCodec
      case ObjectClass.forceblade => WeaponData.genericCodec
      case ObjectClass.fragmentation_grenade => WeaponData.genericCodec
      case ObjectClass.fury_weapon_systema => WeaponData.genericCodec
      case ObjectClass.galaxy_gunship_cannon => WeaponData.genericCodec
      case ObjectClass.galaxy_gunship_gun => WeaponData.genericCodec
      case ObjectClass.galaxy_gunship_tailgun => WeaponData.genericCodec
      case ObjectClass.gauss => WeaponData.genericCodec
      case ObjectClass.gauss_cannon => WeaponData.genericCodec
      case ObjectClass.grenade_launcher_marauder => WeaponData.genericCodec
      case ObjectClass.heavy_rail_beam_magrider => WeaponData.genericCodec
      case ObjectClass.heavy_sniper => WeaponData.genericCodec
      case ObjectClass.hellfire => WeaponData.genericCodec
      case ObjectClass.hunterseeker => WeaponData.genericCodec
      case ObjectClass.ilc9 => WeaponData.genericCodec
      case ObjectClass.isp => WeaponData.genericCodec
      case ObjectClass.katana => WeaponData.genericCodec
      case ObjectClass.lancer => WeaponData.genericCodec
      case ObjectClass.lasher => WeaponData.genericCodec
      case ObjectClass.liberator_25mm_cannon => WeaponData.genericCodec
      case ObjectClass.liberator_bomb_bay => WeaponData.genericCodec
      case ObjectClass.liberator_weapon_system => WeaponData.genericCodec
      case ObjectClass.lightgunship_weapon_system => WeaponData.genericCodec
      case ObjectClass.lightning_weapon_system => WeaponData.genericCodec
      case ObjectClass.maelstrom => WeaponData.genericCodec
      case ObjectClass.magcutter => WeaponData.genericCodec
      case ObjectClass.mediumtransport_weapon_systemA => WeaponData.genericCodec
      case ObjectClass.mediumtransport_weapon_systemB => WeaponData.genericCodec
//      case ObjectClass.mini_chaingun => WeaponData.genericCodec
      case ObjectClass.mini_chaingun => ConcurrentFeedWeaponData.genericCodec
      case ObjectClass.oicw => WeaponData.genericCodec
      case ObjectClass.particle_beam_magrider => WeaponData.genericCodec
      case ObjectClass.pellet_gun => WeaponData.genericCodec
      case ObjectClass.peregrine_dual_machine_gun => WeaponData.genericCodec
      case ObjectClass.peregrine_dual_machine_gun_left => WeaponData.genericCodec
      case ObjectClass.peregrine_dual_machine_gun_right => WeaponData.genericCodec
      case ObjectClass.peregrine_dual_rocket_pods => WeaponData.genericCodec
      case ObjectClass.peregrine_mechhammer => WeaponData.genericCodec
      case ObjectClass.peregrine_mechhammer_left => WeaponData.genericCodec
      case ObjectClass.peregrine_mechhammer_right => WeaponData.genericCodec
      case ObjectClass.peregrine_particle_cannon => WeaponData.genericCodec
      case ObjectClass.peregrine_sparrow => WeaponData.genericCodec
      case ObjectClass.peregrine_sparrow_left => WeaponData.genericCodec
      case ObjectClass.peregrine_sparrow_right => WeaponData.genericCodec
      case ObjectClass.phalanx_avcombo => WeaponData.genericCodec
      case ObjectClass.phalanx_flakcombo => WeaponData.genericCodec
      case ObjectClass.phalanx_sgl_hevgatcan => WeaponData.genericCodec
      case ObjectClass.phantasm_12mm_machinegun => WeaponData.genericCodec
      case ObjectClass.phoenix => WeaponData.genericCodec
      case ObjectClass.prowler_weapon_systemA => WeaponData.genericCodec
      case ObjectClass.prowler_weapon_systemB => WeaponData.genericCodec
      case ObjectClass.pulsar => WeaponData.genericCodec
      case ObjectClass.pulsed_particle_accelerator => WeaponData.genericCodec
      case ObjectClass.punisher => ConcurrentFeedWeaponData.genericCodec
      case ObjectClass.quadassault_weapon_system => WeaponData.genericCodec
      case ObjectClass.r_shotgun => WeaponData.genericCodec
      case ObjectClass.radiator => WeaponData.genericCodec
      case ObjectClass.repeater => WeaponData.genericCodec
      case ObjectClass.rocklet => WeaponData.genericCodec
      case ObjectClass.rotarychaingun_mosquito => WeaponData.genericCodec
      case ObjectClass.router_telepad => WeaponData.genericCodec
      case ObjectClass.scythe => WeaponData.genericCodec
      case ObjectClass.six_shooter => WeaponData.genericCodec
      case ObjectClass.skyguard_weapon_system => WeaponData.genericCodec
      case ObjectClass.spiker => WeaponData.genericCodec
      case ObjectClass.spitfire_aa_weapon => WeaponData.genericCodec
      case ObjectClass.spitfire_weapon => WeaponData.genericCodec
      case ObjectClass.striker => WeaponData.genericCodec
      case ObjectClass.suppressor => WeaponData.genericCodec
      case ObjectClass.thumper => WeaponData.genericCodec
      case ObjectClass.thunderer_weapon_systema => WeaponData.genericCodec
      case ObjectClass.thunderer_weapon_systemb => WeaponData.genericCodec
      case ObjectClass.vanguard_weapon_system => WeaponData.genericCodec
      case ObjectClass.vanu_sentry_turret_weapon => WeaponData.genericCodec
      case ObjectClass.vulture_bomb_bay => WeaponData.genericCodec
      case ObjectClass.vulture_nose_weapon_system => WeaponData.genericCodec
      case ObjectClass.vulture_tail_cannon => WeaponData.genericCodec
      case ObjectClass.wasp_weapon_system => WeaponData.genericCodec
      case ObjectClass.winchester => WeaponData.genericCodec
      case ObjectClass.dynomite => WeaponData.genericCodec
      case ObjectClass.frag_grenade => WeaponData.genericCodec
      case ObjectClass.generic_grenade => WeaponData.genericCodec
      case ObjectClass.jammer_grenade => WeaponData.genericCodec
      case ObjectClass.mine_sweeper => WeaponData.genericCodec
      case ObjectClass.plasma_grenade => WeaponData.genericCodec
      //tools - medkits
      case ObjectClass.avatar => CharacterData.genericCodec
      case ObjectClass.locker_container => AmmoBoxData.genericCodec

      case ObjectClass.remote_electronics_kit => REKData.genericCodec
      case ObjectClass.trek => WeaponData.genericCodec
      case ObjectClass.medkit => AmmoBoxData.genericCodec
      case ObjectClass.super_armorkit => AmmoBoxData.genericCodec
      case ObjectClass.super_medkit => AmmoBoxData.genericCodec
      case ObjectClass.super_staminakit => AmmoBoxData.genericCodec
      case ObjectClass.applicator => WeaponData.genericCodec
      case ObjectClass.medicalapplicator => WeaponData.genericCodec
      case ObjectClass.bank => WeaponData.genericCodec
      case ObjectClass.nano_dispenser => WeaponData.genericCodec
      case ObjectClass.command_detonater => WeaponData.genericCodec




              //failure case
      case _ => conditional(false, bool).exmap[ConstructorData.genericPattern] (
        {
          case None | _ =>
            Attempt.failure(Err("decoding unknown object class"))
        },
        {
          case None | _ =>
            Attempt.failure(Err("encoding unknown object class"))
        }
      )
    }
  }
}
