// Copyright (c) 2016 PSForever.net to present
package net.psforever.packet.game

import net.psforever.packet.{GamePacketOpcode, Marshallable, PacketHelpers, PlanetSideGamePacket}
import scodec.Codec
import scodec.codecs._


case class PlanetSideZoneID(zoneId : Long)

object PlanetSideZoneID {
  implicit val codec = uint32L.as[PlanetSideZoneID]
}

case class PlanetSideGUID(guid : Int)

object PlanetSideGUID {
  implicit val codec = uint16L.as[PlanetSideGUID]
}

/**
  * Is sent by the PlanetSide world server when sending character selection screen state. Provides metadata
  * about a certain character for rendering purposes (zone background, etc). Acts as an array insert for the
  * client character list. A blank displayed character is most likely caused by a mismatch between an
  * ObjectCreateMessage GUID and the GUID from this message.
  */
final case class CharacterInfoMessage(zoneId : PlanetSideZoneID,
                                      charId : Long,
                                      guid : PlanetSideGUID,
                                      secondsSinceLastLogin : Long)
  extends PlanetSideGamePacket {
  type Packet = CharacterInfoMessage
  def opcode = GamePacketOpcode.CharacterInfoMessage
  def encode = CharacterInfoMessage.encode(this)
}

object CharacterInfoMessage extends Marshallable[CharacterInfoMessage] {
  implicit val codec : Codec[CharacterInfoMessage] = (
      ("unknown" | uint32L).unit(0) ::
      ("zoneId" | PlanetSideZoneID.codec) ::
        ("charId" | uint32L) ::
        ("charGUID" | PlanetSideGUID.codec) ::
        ("unknown_bit" | bool.unit(false)) ::
        ("seconds_since_last_login" | uint32L)
    ).as[CharacterInfoMessage]
}