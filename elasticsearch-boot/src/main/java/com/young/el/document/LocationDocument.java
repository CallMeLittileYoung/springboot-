package com.young.el.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
	
	@Document(indexName = LocationDocument.indexName,type=LocationDocument.type)
public class LocationDocument implements Serializable{
	
	public static final String indexName="locations"; 
	public static final String type="location"; 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2306751501040236220L;
	@Id
	@Field(type=FieldType.keyword)
	private Long id;
	//省份id
	@Field(type=FieldType.Long)
	private Long provinceId;
	//省份名称
	@Field(type=FieldType.text)
	private String provinceName;
	//城市id
	@Field(type=FieldType.Long)
	private Long cityId;
	//城市名称
	@Field(type=FieldType.text)
	private String cityName;
	//县级id
	@Field(type=FieldType.Long)
	private Long countyId;
	//县级名称
	@Field(type=FieldType.text)
	private String countyName;
	//城镇id
	@Field(type=FieldType.Long)
	private Long townId;
	//城镇名称
	@Field(type=FieldType.text)
	private String townName;
	//村级id
	@Field(type=FieldType.Long)
	private Long villageId;
	//村级名称
	@Field(type=FieldType.text)
	private String villageName;
	//精度
	@Field(type=FieldType.Double)
	private double longitude;
	//纬度
	@Field(type=FieldType.Double)
	private double latitude;
	//非序列化
	@Field(type=FieldType.Double)
	private double distance;
	
	public LocationDocument() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Long getCountyId() {
		return countyId;
	}

	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public Long getTownId() {
		return townId;
	}

	public void setTownId(Long townId) {
		this.townId = townId;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public Long getVillageId() {
		return villageId;
	}

	public void setVillageId(Long villageId) {
		this.villageId = villageId;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "LocationDocument [id=" + id + ", provinceId=" + provinceId + ", provinceName=" + provinceName
				+ ", cityId=" + cityId + ", cityName=" + cityName + ", countyId=" + countyId + ", countyName="
				+ countyName + ", townId=" + townId + ", townName=" + townName + ", villageId=" + villageId
				+ ", villageName=" + villageName + ", longitude=" + longitude + ", latitude=" + latitude + ", distance="
				+ distance + "]";
	}
}
