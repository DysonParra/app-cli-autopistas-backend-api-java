/*
 * @fileoverview    {UsuarioDTO}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementation done.
 * @version 2.0     Documentation added.
 */
package com.project.dev.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Definición de {@code UsuarioDTO}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class UsuarioDTO {

    private Long intCedulaUsuario;
    private String strNombreUsuario;
    private String strApellidoUsuario;
    private String strSeudonimo;
    private Character enmTipoUsuario;
    private String strContrasena;
    private String strCargoUsuario;

}
