Feature:
  Scenario Outline: validar la compra de viaje medellin-puerto berrio ida y vuelta, sillas y bus expreso
    Given ingreso a pinbus y realizo la busqueda de acuerdo a las especificaciones <id>
    When filtro por requerimientos
    Then coloco la informacion de pasajero
    Examples:
      | id |
      | 1  |