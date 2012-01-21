//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.03.28 at 11:05:57 PM PDT 
//


package com.cmpe276.dbase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for ModelDescriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModelDescriptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Culture">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}language">
 *               &lt;maxLength value="6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{}ProductDescription"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ProductDescriptionID" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ProductModelID" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModelDescriptionType", propOrder = {
    "culture",
    "productDescription"
})
public class ModelDescriptionType {

    @XmlElement(name = "Culture", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String culture;
    @XmlElement(name = "ProductDescription", required = true)
    protected ProductDescriptionType productDescription;
    @XmlAttribute(name = "ProductDescriptionID", required = true)
    protected int productDescriptionID;
    @XmlAttribute(name = "ProductModelID", required = true)
    protected int productModelID;

    /**
     * Gets the value of the culture property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCulture() {
        return culture;
    }

    /**
     * Sets the value of the culture property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCulture(String value) {
        this.culture = value;
    }

    /**
     * Gets the value of the productDescription property.
     * 
     * @return
     *     possible object is
     *     {@link ProductDescriptionType }
     *     
     */
    public ProductDescriptionType getProductDescription() {
        return productDescription;
    }

    /**
     * Sets the value of the productDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductDescriptionType }
     *     
     */
    public void setProductDescription(ProductDescriptionType value) {
        this.productDescription = value;
    }

    /**
     * Gets the value of the productDescriptionID property.
     * 
     */
    public int getProductDescriptionID() {
        return productDescriptionID;
    }

    /**
     * Sets the value of the productDescriptionID property.
     * 
     */
    public void setProductDescriptionID(int value) {
        this.productDescriptionID = value;
    }

    /**
     * Gets the value of the productModelID property.
     * 
     */
    public int getProductModelID() {
        return productModelID;
    }

    /**
     * Sets the value of the productModelID property.
     * 
     */
    public void setProductModelID(int value) {
        this.productModelID = value;
    }

}