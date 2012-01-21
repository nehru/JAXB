//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.03.28 at 11:05:57 PM PDT 
//


package com.cmpe276.dbase;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cmpe276.dbase package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Customer_QNAME = new QName("", "Customer");
    private final static QName _CustomerAddress_QNAME = new QName("", "CustomerAddress");
    private final static QName _Product_QNAME = new QName("", "Product");
    private final static QName _SalesOrderDetail_QNAME = new QName("", "SalesOrderDetail");
    private final static QName _SalesOrder_QNAME = new QName("", "SalesOrder");
    private final static QName _Address_QNAME = new QName("", "Address");
    private final static QName _ProductDescription_QNAME = new QName("", "ProductDescription");
    private final static QName _ProductCategory_QNAME = new QName("", "ProductCategory");
    private final static QName _ProductModel_QNAME = new QName("", "ProductModel");
    private final static QName _ModelDescription_QNAME = new QName("", "ModelDescription");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cmpe276.dbase
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link ProductModelType }
     * 
     */
    public ProductModelType createProductModelType() {
        return new ProductModelType();
    }

    /**
     * Create an instance of {@link CustomerAddressType }
     * 
     */
    public CustomerAddressType createCustomerAddressType() {
        return new CustomerAddressType();
    }

    /**
     * Create an instance of {@link ProductDescriptionType }
     * 
     */
    public ProductDescriptionType createProductDescriptionType() {
        return new ProductDescriptionType();
    }

    /**
     * Create an instance of {@link SalesOrderType }
     * 
     */
    public SalesOrderType createSalesOrderType() {
        return new SalesOrderType();
    }

    /**
     * Create an instance of {@link ProductCategoryType }
     * 
     */
    public ProductCategoryType createProductCategoryType() {
        return new ProductCategoryType();
    }

    /**
     * Create an instance of {@link ProductType }
     * 
     */
    public ProductType createProductType() {
        return new ProductType();
    }

    /**
     * Create an instance of {@link SalesOrderDetailType }
     * 
     */
    public SalesOrderDetailType createSalesOrderDetailType() {
        return new SalesOrderDetailType();
    }

    /**
     * Create an instance of {@link CustomerType }
     * 
     */
    public CustomerType createCustomerType() {
        return new CustomerType();
    }

    /**
     * Create an instance of {@link ModelDescriptionType }
     * 
     */
    public ModelDescriptionType createModelDescriptionType() {
        return new ModelDescriptionType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Customer")
    public JAXBElement<CustomerType> createCustomer(CustomerType value) {
        return new JAXBElement<CustomerType>(_Customer_QNAME, CustomerType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerAddressType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CustomerAddress")
    public JAXBElement<CustomerAddressType> createCustomerAddress(CustomerAddressType value) {
        return new JAXBElement<CustomerAddressType>(_CustomerAddress_QNAME, CustomerAddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Product")
    public JAXBElement<ProductType> createProduct(ProductType value) {
        return new JAXBElement<ProductType>(_Product_QNAME, ProductType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SalesOrderDetailType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SalesOrderDetail")
    public JAXBElement<SalesOrderDetailType> createSalesOrderDetail(SalesOrderDetailType value) {
        return new JAXBElement<SalesOrderDetailType>(_SalesOrderDetail_QNAME, SalesOrderDetailType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SalesOrderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SalesOrder")
    public JAXBElement<SalesOrderType> createSalesOrder(SalesOrderType value) {
        return new JAXBElement<SalesOrderType>(_SalesOrder_QNAME, SalesOrderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Address")
    public JAXBElement<AddressType> createAddress(AddressType value) {
        return new JAXBElement<AddressType>(_Address_QNAME, AddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductDescriptionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ProductDescription")
    public JAXBElement<ProductDescriptionType> createProductDescription(ProductDescriptionType value) {
        return new JAXBElement<ProductDescriptionType>(_ProductDescription_QNAME, ProductDescriptionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductCategoryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ProductCategory")
    public JAXBElement<ProductCategoryType> createProductCategory(ProductCategoryType value) {
        return new JAXBElement<ProductCategoryType>(_ProductCategory_QNAME, ProductCategoryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductModelType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ProductModel")
    public JAXBElement<ProductModelType> createProductModel(ProductModelType value) {
        return new JAXBElement<ProductModelType>(_ProductModel_QNAME, ProductModelType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModelDescriptionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ModelDescription")
    public JAXBElement<ModelDescriptionType> createModelDescription(ModelDescriptionType value) {
        return new JAXBElement<ModelDescriptionType>(_ModelDescription_QNAME, ModelDescriptionType.class, null, value);
    }

}