/*
 * Simple API
 * Simple API Description
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package de.andrestefanov.android.nearbuy.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.andrestefanov.android.nearbuy.api.model.ShoppingListRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ShoppingList
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-03-22T15:06:40.738994+01:00[Europe/Berlin]")
public class ShoppingList {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private BigDecimal id;

  public static final String SERIALIZED_NAME_OWNER = "owner";
  @SerializedName(SERIALIZED_NAME_OWNER)
  private BigDecimal owner;

  public static final String SERIALIZED_NAME_CREATED_AT = "created_at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private Date createdAt;

  public static final String SERIALIZED_NAME_UPDATED_AT = "updated_at";
  @SerializedName(SERIALIZED_NAME_UPDATED_AT)
  private Date updatedAt;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private String status;

  public static final String SERIALIZED_NAME_REQUESTS = "requests";
  @SerializedName(SERIALIZED_NAME_REQUESTS)
  private List<ShoppingListRequest> requests = new ArrayList<ShoppingListRequest>();


  public ShoppingList id(BigDecimal id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")

  public BigDecimal getId() {
    return id;
  }


  public void setId(BigDecimal id) {
    this.id = id;
  }


  public ShoppingList owner(BigDecimal owner) {
    
    this.owner = owner;
    return this;
  }

   /**
   * Get owner
   * @return owner
  **/
  @ApiModelProperty(required = true, value = "")

  public BigDecimal getOwner() {
    return owner;
  }


  public void setOwner(BigDecimal owner) {
    this.owner = owner;
  }


  public ShoppingList createdAt(Date createdAt) {
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(required = true, value = "")

  public Date getCreatedAt() {
    return createdAt;
  }


  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }


  public ShoppingList updatedAt(Date updatedAt) {
    
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @ApiModelProperty(required = true, value = "")

  public Date getUpdatedAt() {
    return updatedAt;
  }


  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }


  public ShoppingList status(String status) {
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")

  public String getStatus() {
    return status;
  }


  public void setStatus(String status) {
    this.status = status;
  }


  public ShoppingList requests(List<ShoppingListRequest> requests) {
    
    this.requests = requests;
    return this;
  }

  public ShoppingList addRequestsItem(ShoppingListRequest requestsItem) {
    this.requests.add(requestsItem);
    return this;
  }

   /**
   * Get requests
   * @return requests
  **/
  @ApiModelProperty(required = true, value = "")

  public List<ShoppingListRequest> getRequests() {
    return requests;
  }


  public void setRequests(List<ShoppingListRequest> requests) {
    this.requests = requests;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShoppingList shoppingList = (ShoppingList) o;
    return Objects.equals(this.id, shoppingList.id) &&
        Objects.equals(this.owner, shoppingList.owner) &&
        Objects.equals(this.createdAt, shoppingList.createdAt) &&
        Objects.equals(this.updatedAt, shoppingList.updatedAt) &&
        Objects.equals(this.status, shoppingList.status) &&
        Objects.equals(this.requests, shoppingList.requests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, owner, createdAt, updatedAt, status, requests);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShoppingList {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    requests: ").append(toIndentedString(requests)).append("\n");
    sb.append("}");
    return sb.toString();
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

}

