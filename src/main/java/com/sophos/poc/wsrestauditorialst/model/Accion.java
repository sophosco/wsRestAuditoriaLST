package com.sophos.poc.wsrestauditorialst.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
@RedisHash("AccionUsuarioDTO")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-24T18:02:46.113Z")
public class Accion {

	  @Id 
	  @JsonProperty("RqUID")
	  private String rqUID = null;
	
	  @JsonProperty("FechaCreacion")
	  private String fechaCreacion = null;
	  
	  @JsonProperty("IdSesion")
	  private String idSesion = null;

	  @JsonProperty("IdUsuario")
	  private String idUsuario = null;

	  @JsonProperty("TipoAccion")
	  private String tipoAccion = null;

	  @JsonProperty("DescripcionAccion")
	  private String descripcionAccion = null;

	  @JsonProperty("ModuloAplicacion")
	  private String moduloAplicacion = null;

	  @JsonProperty("IdProducto")
	  private String idProducto = null;

	  @JsonProperty("IdCategoria")
	  private String idCategoria = null;
	  
	  @JsonProperty("MessageData")
	  private String messageData = null;

	  public Accion fechaCreacion(String fechaCreacion) {
	    this.fechaCreacion = fechaCreacion;
	    return this;
	  }

	  /**
	   * Get fechaCreacion
	   * @return fechaCreacion
	  **/
	  @ApiModelProperty(value = "")
	  @Valid
	  public String getFechaCreacion() {
	    return fechaCreacion;
	  }

	  public void setFechaCreacion(String fechaCreacion) {
	    this.fechaCreacion = fechaCreacion;
	  }

	  public Accion idSesion(String idSesion) {
	    this.idSesion = idSesion;
	    return this;
	  }

	  /**
	   * Get idSesion
	   * @return idSesion
	  **/
	  @ApiModelProperty(value = "")


	  public String getIdSesion() {
	    return idSesion;
	  }

	  public void setIdSesion(String idSesion) {
	    this.idSesion = idSesion;
	  }

	  public Accion idUsuario(String idUsuario) {
	    this.idUsuario = idUsuario;
	    return this;
	  }

	  /**
	   * Get idUsuario
	   * @return idUsuario
	  **/
	  @ApiModelProperty(value = "")


	  public String getIdUsuario() {
	    return idUsuario;
	  }

	  public void setIdUsuario(String idUsuario) {
	    this.idUsuario = idUsuario;
	  }

	  public Accion tipoAccion(String tipoAccion) {
	    this.tipoAccion = tipoAccion;
	    return this;
	  }

	  /**
	   * Get tipoAccion
	   * @return tipoAccion
	  **/
	  @ApiModelProperty(value = "")


	  public String getTipoAccion() {
	    return tipoAccion;
	  }

	  public void setTipoAccion(String tipoAccion) {
	    this.tipoAccion = tipoAccion;
	  }

	  public Accion descripcionAccion(String descripcionAccion) {
	    this.descripcionAccion = descripcionAccion;
	    return this;
	  }

	  /**
	   * Get descripcionAccion
	   * @return descripcionAccion
	  **/
	  @ApiModelProperty(value = "")


	  public String getDescripcionAccion() {
	    return descripcionAccion;
	  }

	  public void setDescripcionAccion(String descripcionAccion) {
	    this.descripcionAccion = descripcionAccion;
	  }

	  public Accion moduloAplicacion(String moduloAplicacion) {
	    this.moduloAplicacion = moduloAplicacion;
	    return this;
	  }

	  /**
	   * Get moduloAplicacion
	   * @return moduloAplicacion
	  **/
	  @ApiModelProperty(value = "")


	  public String getModuloAplicacion() {
	    return moduloAplicacion;
	  }

	  public void setModuloAplicacion(String moduloAplicacion) {
	    this.moduloAplicacion = moduloAplicacion;
	  }

	  public Accion idProducto(String idProducto) {
	    this.idProducto = idProducto;
	    return this;
	  }

	  /**
	   * Get idProducto
	   * @return idProducto
	  **/
	  @ApiModelProperty(value = "")


	  public String getIdProducto() {
	    return idProducto;
	  }

	  public void setIdProducto(String idProducto) {
	    this.idProducto = idProducto;
	  }

	  public Accion idCategoria(String idCategoria) {
	    this.idCategoria = idCategoria;
	    return this;
	  }

	  /**
	   * Get idCategoria
	   * @return idCategoria
	  **/
	  @ApiModelProperty(value = "")


	  public String getIdCategoria() {
	    return idCategoria;
	  }

	  public void setIdCategoria(String idCategoria) {
	    this.idCategoria = idCategoria;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    Accion accion = (Accion) o;
	    return Objects.equals(this.fechaCreacion, accion.fechaCreacion) &&
	        Objects.equals(this.idSesion, accion.idSesion) &&
	        Objects.equals(this.idUsuario, accion.idUsuario) &&
	        Objects.equals(this.tipoAccion, accion.tipoAccion) &&
	        Objects.equals(this.descripcionAccion, accion.descripcionAccion) &&
	        Objects.equals(this.moduloAplicacion, accion.moduloAplicacion) &&
	        Objects.equals(this.idProducto, accion.idProducto) &&
	        Objects.equals(this.idCategoria, accion.idCategoria);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(fechaCreacion, idSesion, idUsuario, tipoAccion, descripcionAccion, moduloAplicacion, idProducto, idCategoria);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class Accion {\n");
	    
	    sb.append("    fechaCreacion: ").append(toIndentedString(fechaCreacion)).append("\n");
	    sb.append("    idSesion: ").append(toIndentedString(idSesion)).append("\n");
	    sb.append("    idUsuario: ").append(toIndentedString(idUsuario)).append("\n");
	    sb.append("    tipoAccion: ").append(toIndentedString(tipoAccion)).append("\n");
	    sb.append("    descripcionAccion: ").append(toIndentedString(descripcionAccion)).append("\n");
	    sb.append("    moduloAplicacion: ").append(toIndentedString(moduloAplicacion)).append("\n");
	    sb.append("    idProducto: ").append(toIndentedString(idProducto)).append("\n");
	    sb.append("    idCategoria: ").append(toIndentedString(idCategoria)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }

	  public String getRqUID() {
		return rqUID;
	}

	public void setRqUID(String rqUID) {
		this.rqUID = rqUID;
	}

	/**
	   * Convert the given object to string with each line indented by 4 spaces
	   * (except the first line).
	   */
	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }

	public String getMessageData() {
		return messageData;
	}

	public void setMessageData(String messageData) {
		this.messageData = messageData;
	}
	  
}
