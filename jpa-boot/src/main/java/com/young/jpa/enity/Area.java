package com.young.jpa.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author        Young
 * @description   地区实体类
 * @date          2018年7月24日 下午10:19:18 
 *
 */
@Entity
@Table(name="T_AREA")
public class Area implements java.io.Serializable {
	
	 private static final long serialVersionUID = -7652933350076787771L;
	 private Long id;
     private String areacode;
     private String province;
     private String city;
     private String district;
     private String postcode;
     private String citycode;
     private String shortcode;
     private String showName;
    public Area() {
    }
    public Area(String areacode, String province, String city, String district, String postcode, String citycode, String shortcode) {
        this.areacode = areacode;
        this.province = province;
        this.city = city;
        this.district = district;
        this.postcode = postcode;
        this.citycode = citycode;
        this.shortcode = shortcode;
    }

   
   // @SequenceGenerator(name="generator",sequenceName="T_AREA_SEQ",allocationSize=1)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", unique=true, nullable=false, precision=10, scale=0)

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="AREACODE", length=100)

    public String getAreacode() {
        return this.areacode;
    }
    
    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }
    
    @Column(name="PROVINCE")

    public String getProvince() {
        return this.province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    
    @Column(name="CITY")

    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    @Column(name="DISTRICT")

    public String getDistrict() {
        return this.district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    
    @Column(name="POSTCODE", length=100)

    public String getPostcode() {
        return this.postcode;
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    
    @Column(name="CITYCODE")

    public String getCitycode() {
        return this.citycode;
    }
    
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }
    
    @Column(name="SHORTCODE")

    public String getShortcode() {
        return this.shortcode;
    }
    
    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }
    /*@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="area")

    public Set<SubArea> getSubAreas() {
        return this.subAreas;
    }
    
    public void setSubAreas(Set<SubArea> subAreas) {
        this.subAreas = subAreas;
    }*/
    @Transient
	public String getShowName() {
		return province+"-"+city+"-"+district;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}


	@Override
	public String toString() {
		return "Area [id=" + id + ", areacode=" + areacode + ", province=" + province + ", city=" + city + ", district="
				+ district + ", postcode=" + postcode + ", citycode=" + citycode + ", shortcode=" + shortcode
				+ ", showName=" + showName + "]";
	}
	

}