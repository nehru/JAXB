package com.cmpe276;

import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cmpe276.dbase.*;
import com.cmpe276.hibernate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

 

public class Main {

	
	public static void main(String[] args) {
		new Main();

	}
	
	public Main()
	{ 
		 		
		 // Create a variable for the connection string.
	      String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
	            "databaseName=AdventureWorksLT2008;integratedSecurity=true;";

	      // Declare the JDBC objects.
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;
		
		
		
		
	    //Marshalling code starts
		
		SessionFactory sf_address,sf_customer;
		SessionFactory sf_customerAddress;
		SessionFactory sf_salesOrderHeader;
		SessionFactory sf_salesOrderDetail,sf_product,sf_productModel,sf_ModelDescription,sf_ProductDescription,sf_ProductCategory;
		
		Session ss_customer,ss_address,ss_customerAddress,ss_salesOrderHeader,ss_salesOrderDetail;
		Session ss_product,ss_productModel,ss_ModelDescription,ss_ProductDescription,ss_ProductCategory;
	
		HibernateUtil hu = new HibernateUtil();
		
		sf_customer = hu.ConnectDB("hibernate.customer.cfg.xml");
		ss_customer = sf_customer.getCurrentSession();
		ss_customer.beginTransaction();
		 
		Vector<CustomerType> customer = new Vector<CustomerType>(ss_customer.createQuery("from CustomerType").list());
		
		
		// create a JAXBContext
        try {
			JAXBContext jc = JAXBContext.newInstance( "com.cmpe276.dbase" );
		
			// create an empty CustomerType
			CustomerType ct = new CustomerType();
			for (CustomerType c : customer)
			{
				
				if (c.getCustomerID() == 29485) {
					ct.setCustomerID(c.getCustomerID());
					ct.setNameStyle(c.getNameStyle());
					ct.setTitle(c.getTitle());
					ct.setFirstName(c.getFirstName());
					ct.setMiddleName(c.getMiddleName());
					ct.setLastName(c.getLastName());
					ct.setSuffix(c.getSuffix());
					ct.setCompanyName(c.getCompanyName());
					ct.setSalesPerson(c.getSalesPerson());
					ct.setEmailAddress(c.getEmailAddress());
					ct.setPhone(c.getPhone());
					
					//Customer Address
					sf_customerAddress = hu.ConnectDB("hibernate.customeraddress.cfg.xml");
					ss_customerAddress =  sf_customerAddress.getCurrentSession();
					ss_customerAddress.beginTransaction();
					 
					Vector<CustomerAddressType> CustomerAddress = new Vector<CustomerAddressType>(ss_customerAddress.createQuery("from CustomerAddressType").list());
					
					// create an empty CustomerType
					CustomerAddressType cat = new CustomerAddressType();
					for (CustomerAddressType c1 : CustomerAddress)
					{
						
						if(c1.getCustomerID() == 29485){
						 cat.setCustomerID(c1.getCustomerID());
						 cat.setAddressID(c1.getAddressID());
						 cat.setAddressType(c1.getAddressType());
						 
					 
						}
					}
					ct.setCustomerAddress(cat);
					
					//Address table
					sf_address = hu.ConnectDB("hibernate.address.cfg.xml");
					ss_address = sf_address.getCurrentSession();
					ss_address.beginTransaction();
					 
					Vector<AddressType> colors = new Vector<AddressType>(ss_address.createQuery("from AddressType").list());
					
					// create an empty CustomerType
					AddressType at = new AddressType();
					
					for (AddressType c2 : colors)
					{
						
						if(c2.getAddressID() == 595){
							at.setAddressID(c2.getAddressID());
							at.setAddressLine1(c2.getAddressLine1());
							at.setAddressLine2(c2.getAddressLine2());
							at.setCity(c2.getCity());
							at.setStateProvince(c2.getStateProvince());
							at.setCountryRegion(c2.getCountryRegion());
							at.setPostalCode(c2.getPostalCode());
													 
						}
					}
					cat.setAddress(at);
					
					//SalesOrderHeader
					sf_salesOrderHeader = hu.ConnectDB("hibernate.salesorderheader.cfg.xml");
					ss_salesOrderHeader = sf_salesOrderHeader.getCurrentSession();
					ss_salesOrderHeader.beginTransaction();
					 
					Vector<SalesOrderType> csot = new Vector<SalesOrderType>(ss_salesOrderHeader.createQuery("from SalesOrderType").list());
					
					SalesOrderType sot = new SalesOrderType();
					
					for (SalesOrderType c3 : csot)
					{
						if(c3.getCustomerID() == 29485){
							sot.setSalesOrderID(c3.getSalesOrderID());
							sot.setRevisionNumber(c3.getRevisionNumber());
							
							XMLGregorianCalendar OrderDate = readDate(3,"SalesOrderHeader"," CustomerID='29485'");
							sot.setOrderDate(OrderDate);
							
							XMLGregorianCalendar DueDate = readDate(4,"SalesOrderHeader"," CustomerID='29485'");
							sot.setDueDate(DueDate);
							
							XMLGregorianCalendar ShipDate = readDate(5,"SalesOrderHeader"," CustomerID='29485'");
							sot.setShipDate(ShipDate);
							
							sot.setStatus(c3.getStatus());
							sot.setOnlineOrderFlag(c3.isOnlineOrderFlag());
							sot.setSalesOrderNumber(c3.getSalesOrderNumber());
							sot.setPurchaseOrderNumber(c3.getPurchaseOrderNumber());
							sot.setAccountNumber(c3.getAccountNumber());
							sot.setCustomerID(c3.getCustomerID());
							sot.setShipToAddressID(c3.getShipToAddressID());
							sot.setBillToAddressID(c3.getBillToAddressID());
							sot.setShipMethod(c3.getShipMethod());
							sot.setCreditCardApprovalCode(c3.getCreditCardApprovalCode()==null ? "NULL" :c3.getCreditCardApprovalCode());
							sot.setSubTotal(c3.getSubTotal());
							sot.setTaxAmt(c3.getTaxAmt());
							sot.setFreight(c3.getFreight());
							sot.setTotalDue(c3.getSubTotal());
							sot.setComment(c3.getComment()==null ? "NULL" : c3.getComment());
							
							 
						}
					}
					
					ct.setSalesOrder(sot);
					
					//SalesOrderDetail
					
					sf_salesOrderDetail = hu.ConnectDB("hibernate.salesorderdetail.cfg.xml");
					ss_salesOrderDetail = sf_salesOrderDetail.getCurrentSession();
					ss_salesOrderDetail.beginTransaction();
					 
					Vector<SalesOrderDetailType> sodt = new Vector<SalesOrderDetailType>(ss_salesOrderDetail.createQuery("from SalesOrderDetailType").list());
						
					SalesOrderDetailType sod = new SalesOrderDetailType();
					
					for (SalesOrderDetailType c4 : sodt)
					{
						
						if(c4.getSalesOrderID() == 71782){
							sod.setSalesOrderID(c4.getSalesOrderID());
							sod.setSalesOrderDetailID(c4.getSalesOrderDetailID());
							sod.setOrderQty(c4.getOrderQty());
							sod.setProductID(c4.getProductID());
							sod.setUnitPrice(c4.getUnitPrice());
							sod.setUnitPriceDiscount(c4.getUnitPriceDiscount());
							sod.setLineTotal(c4.getLineTotal());
							
						}
					}
					sot.setSalesOrderDetail(sod);
					
					//Product
					
					sf_product = hu.ConnectDB("hibernate.product.cfg.xml");
					ss_product = sf_product.getCurrentSession();
					ss_product.beginTransaction();
					
					Vector<ProductType> pty = new Vector<ProductType>(ss_product.createQuery("from ProductType").list());
						
					ProductType pt = new ProductType();
					
					for (ProductType c5 : pty)
					{
							
						if(c5.getProductID() == 714){
						 pt.setProductID(c5.getProductID());
						 pt.setName(c5.getName());
						 pt.setProductNumber(c5.getProductNumber());
						 pt.setColor(c5.getColor());
						 pt.setStandardCost(c5.getStandardCost());
						 pt.setListPrice(c5.getListPrice());
						 pt.setSize(c5.getSize());
						 						 
						 pt.setWeight(c5.getWeight());
						 pt.setProductCategoryID(c5.getProductCategoryID());
						 pt.setProductModelID(c5.getProductModelID());
						 
						 XMLGregorianCalendar SelStartDate = readDate(11,"Product"," ProductID='714'");
						 pt.setSellStartDate(SelStartDate);
						
						 XMLGregorianCalendar SelEndDate = readDate(12,"Product"," ProductID='714'");
						 pt.setSellEndDate(SelEndDate);
						 
						 XMLGregorianCalendar DiscontinuedDate = readDate(13,"Product"," ProductID='714'");
						 pt.setDiscontinuedDate(DiscontinuedDate);
						 
						 pt.setThumbNailPhoto(c5.getThumbNailPhoto());
						 pt.setThumbnailPhotoFileName(c5.getThumbnailPhotoFileName());
						 
						}
					}
					sod.setProduct(pt);	
					
					//ProductModel
					
					sf_productModel = hu.ConnectDB("hibernate.productmodel.cfg.xml");
					ss_productModel = sf_productModel.getCurrentSession();
					ss_productModel.beginTransaction();
				 
					Vector<ProductModelType> pmtv = new Vector<ProductModelType>(ss_productModel.createQuery("from ProductModelType").list());
						
					ProductModelType pmt = new ProductModelType();
					
					for (ProductModelType c6 : pmtv)
					{
							
							if(c6.getProductModelID() == 11){
							 pmt.setProductModelID(c6.getProductModelID());
							 pmt.setName(c6.getName());
							 pmt.setCatalogDescription((c6.getCatalogDescription() == null) ? "NULL" : c6.getCatalogDescription());
							 
							}
					}
					pt.setProductModel(pmt);
					
					//ModelDescription
					
					sf_ModelDescription = hu.ConnectDB("hibernate.modeldescription.cfg.xml");
					ss_ModelDescription = sf_ModelDescription.getCurrentSession();
					ss_ModelDescription.beginTransaction();
					 
					Vector<ModelDescriptionType> mdtt = new Vector<ModelDescriptionType>(ss_ModelDescription.createQuery("from ModelDescriptionType").list());
						
					 ModelDescriptionType md = new ModelDescriptionType();
					
					for (ModelDescriptionType c7 : mdtt)
					{
						if(c7.getProductModelID() == 11){
							md.setProductModelID(c7.getProductModelID());
							md.setProductDescriptionID(c7.getProductDescriptionID());
							md.setCulture(c7.getCulture());
						}
							
							 
					}
					pmt.setModelDescription(md);
					
					//ProductDescription
					
					sf_ProductDescription = hu.ConnectDB("hibernate.productdescription.cfg.xml");
					ss_ProductDescription = sf_ProductDescription.getCurrentSession();
					ss_ProductDescription.beginTransaction();
					 
					Vector<ProductDescriptionType> pdtt = new Vector<ProductDescriptionType>(ss_ProductDescription.createQuery("from ProductDescriptionType").list());
						
					ProductDescriptionType pdt = new ProductDescriptionType();
					for (ProductDescriptionType c8 :pdtt)
					{
						if(c8.getProductDescriptionID() == 1599){
							pdt.setProductDescriptionID(c8.getProductDescriptionID());
							pdt.setDescription(c8.getDescription());
						}
						
							 
					}
					md.setProductDescription(pdt);
					
					//ProductCategory
					
					sf_ProductCategory = hu.ConnectDB("hibernate.productcategory.cfg.xml");
					ss_ProductCategory = sf_ProductCategory.getCurrentSession();
					ss_ProductCategory.beginTransaction();
					 
					Vector<ProductCategoryType> pc = new Vector<ProductCategoryType>(ss_ProductCategory.createQuery("from ProductCategoryType").list());
						
					ProductCategoryType ppc = new ProductCategoryType();
					for (ProductCategoryType c9 : pc)
					{
						if(c9.getProductCategoryID() == 25){
							ppc.setProductCategoryID(c9.getProductCategoryID());
							ppc.setParentProductCategoryID(c9.getParentProductCategoryID());
							ppc.setName(c9.getName());
						}
							
							 
					}
					pt.setProductCategory(ppc);
					
				}
			}
			
			// create an element for marshalling
		    JAXBElement<CustomerType> poElement = (new ObjectFactory()).createCustomer(ct);

		 // create a Marshaller and marshal to System.out
            Marshaller m = jc.createMarshaller();
            m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
            m.marshal( poElement, System.out );
        
        } catch (JAXBException e) {
			 
			e.printStackTrace();
		}
        
        //Marshalling code ends
        
        
      //*****************************************************************************************************
      //*****************************************************************************************************  
    	
        //UnMarshalling code starts  
        
		try {
			// create a JAXBContext capable of handling classes generated into
			// the primer.po package
			JAXBContext jc = JAXBContext.newInstance("com.cmpe276.dbase");

			// create an Unmarshaller
			Unmarshaller u = jc.createUnmarshaller();

			// unmarshal a po instance document into a tree of Java content
			// objects composed of classes from the com.cmpe276.dbase package.
			JAXBElement<?> poElement = (JAXBElement<?>) u
					.unmarshal(new FileInputStream("customer9.xml"));
			
			//Getting data from xml file
			CustomerType po = (CustomerType) poElement.getValue();
			
			//System.out.println(po.getFirstName()+ " "+ po.getLastName());
            //System.out.println(po.getCustomerID() +" "+ po.getEmailAddress());
            
            
            try {
                
                // Establish the connection.
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(connectionUrl);

               //Customer
                
                // Create and execute an SQL statement, retrieving an updateable result set.
                String SQL = "SELECT * FROM SalesLT.Customer;";
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery(SQL);
                
                // Insert a row of data.
                rs.moveToInsertRow();
               
               // rs.updateInt("CustomerID", po.getCustomerID());
                rs.updateByte("NameStyle", po.getNameStyle());
                rs.updateString("Title", po.getTitle());
                rs.updateString("FirstName", po.getFirstName());
                rs.updateString("MiddleName", po.getMiddleName());
                rs.updateString("LastName", po.getLastName());
                rs.updateString("CompanyName", po.getCompanyName());
                rs.updateString("SalesPerson", po.getSalesPerson());
                rs.updateString("EmailAddress", po.getEmailAddress());
                rs.updateString("Phone", po.getPhone());
                          
                rs.updateString("PasswordHash", "abcd");
                rs.updateString("PasswordSalt", "abcd");
                
                rs.insertRow();
                
                //Address
                
                String SQL1 = "SELECT * FROM SalesLT.Address;";
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery(SQL1);
                
                // Insert a row of data.
                rs.moveToInsertRow();
                
                System.out.println("*****"+po.getCustomerAddress().getAddress().getAddressLine1());
                
                rs.updateString("AddressLine1", po.getCustomerAddress().getAddress().getAddressLine1());
                rs.updateString("AddressLine2", po.getCustomerAddress().getAddress().getAddressLine2());
                rs.updateString("City", po.getCustomerAddress().getAddress().getCity());
                rs.updateString("StateProvince", po.getCustomerAddress().getAddress().getStateProvince());
                rs.updateString("CountryRegion", po.getCustomerAddress().getAddress().getCountryRegion());
                rs.updateString("PostalCode", po.getCustomerAddress().getAddress().getPostalCode());
                
                rs.insertRow();
         
                
                //CustomerAddress
                
             // Create and execute an SQL statement, retrieving an updateable result set.
                String SQL2 = "SELECT * FROM SalesLT.CustomerAddress;";
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery(SQL2);
                
                // Insert a row of data.
                rs.moveToInsertRow();
                
                rs.updateInt("CustomerID", po.getCustomerID());
                rs.updateInt("AddressID", po.getCustomerAddress().getAddress().getAddressID());
                rs.updateString("AddressType", po.getCustomerAddress().getAddressType());
                                
                rs.insertRow();
             
                
                
                //SalesOrderHeader
                
                String SQL3 = "SELECT * FROM SalesLT.SalesOrderHeader;";
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery(SQL3);
                
             // Insert a row of data.
                rs.moveToInsertRow();
                rs.updateInt("RevisionNumber", po.getSalesOrder().getRevisionNumber());
                rs.updateString("OrderDate",  po.getSalesOrder().getOrderDate().toString());
                rs.updateString("DueDate", po.getSalesOrder().getDueDate().toString());
                rs.updateString("ShipDate", po.getSalesOrder().getShipDate().toString());
                rs.updateInt("Status", po.getSalesOrder().getStatus());
                rs.updateInt("OnlineOrderFlag", po.getSalesOrder().isOnlineOrderFlag());
              //  rs.updateString("SalesOrderNumber", po.getSalesOrder().getSalesOrderNumber());
                rs.updateString("PurchaseOrderNumber", po.getSalesOrder().getPurchaseOrderNumber());
                rs.updateString("AccountNumber", po.getSalesOrder().getAccountNumber());
                rs.updateInt("CustomerID", po.getSalesOrder().getCustomerID());
                rs.updateInt("ShipToAddressID", po.getSalesOrder().getShipToAddressID());
                rs.updateInt("BillToAddressID", po.getSalesOrder().getBillToAddressID());
                rs.updateString("ShipMethod", po.getSalesOrder().getShipMethod());
                rs.updateString("CreditCardApprovalCode", po.getSalesOrder().getCreditCardApprovalCode());
                rs.updateDouble("SubTotal", po.getSalesOrder().getSubTotal());
                rs.updateDouble("TaxAmt", po.getSalesOrder().getTaxAmt());
                rs.updateDouble("Freight", po.getSalesOrder().getFreight());
              //  rs.updateDouble("TotalDue", po.getSalesOrder().getTotalDue());
                rs.updateString("Comment", po.getSalesOrder().getComment());
                
                rs.insertRow();
                
           
                //ProductModel
                String SQL4 = "SELECT * FROM SalesLT.ProductModel;";
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery(SQL4);
                
             // Insert a row of data.
                rs.moveToInsertRow();
                 
                rs.updateString("Name", po.getSalesOrder().getSalesOrderDetail().getProduct().getProductModel().getName());
                //rs.updateString("CatalogDescription", po.getSalesOrder().getSalesOrderDetail().getProduct().getProductModel().getCatalogDescription());
                rs.insertRow();
                
                //ProductCategory
                String SQL5 = "SELECT * FROM SalesLT.ProductCategory;";
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery(SQL5);
                
                rs.moveToInsertRow();
                
                rs.updateInt("ParentProductCategoryID", po.getSalesOrder().getSalesOrderDetail().getProduct().getProductCategory().getParentProductCategoryID());
                rs.updateString("Name", po.getSalesOrder().getSalesOrderDetail().getProduct().getProductCategory().getName());
                rs.insertRow();
                
                
                //Product
                String SQL6 = "SELECT * FROM SalesLT.Product;";
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery(SQL6);
                
             
                rs.moveToInsertRow();
                
                rs.updateString("Name", po.getSalesOrder().getSalesOrderDetail().getProduct().getName());
                rs.updateString("ProductNumber", po.getSalesOrder().getSalesOrderDetail().getProduct().getProductNumber());
                rs.updateString("Color", po.getSalesOrder().getSalesOrderDetail().getProduct().getColor());
                rs.updateDouble("StandardCost", po.getSalesOrder().getSalesOrderDetail().getProduct().getStandardCost());
                rs.updateDouble("ListPrice", po.getSalesOrder().getSalesOrderDetail().getProduct().getListPrice());
                rs.updateString("Size", po.getSalesOrder().getSalesOrderDetail().getProduct().getSize());
                //rs.updateDouble("Weight", po.getSalesOrder().getSalesOrderDetail().getProduct().getWeight());
                
                rs.updateInt("ProductCategoryID", po.getSalesOrder().getSalesOrderDetail().getProduct().getProductCategoryID());
                rs.updateInt("ProductModelID", po.getSalesOrder().getSalesOrderDetail().getProduct().getProductModelID());
                rs.updateString("SellStartDate", po.getSalesOrder().getSalesOrderDetail().getProduct().getSellStartDate().toString());
                rs.updateString("SellEndDate", po.getSalesOrder().getSalesOrderDetail().getProduct().getSellEndDate().toString());
                rs.updateString("DiscontinuedDate", po.getSalesOrder().getSalesOrderDetail().getProduct().getDiscontinuedDate().toString());
                rs.updateBytes("ThumbNailPhoto", po.getSalesOrder().getSalesOrderDetail().getProduct().getThumbNailPhoto());
                rs.updateString("ThumbnailPhotoFileName", po.getSalesOrder().getSalesOrderDetail().getProduct().getThumbnailPhotoFileName());
                rs.insertRow();
                
                  
                //SalesOrderDetail
                
                String SQL7 = "SELECT * FROM SalesLT.SalesOrderDetail;";
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery(SQL7);
                
             // Insert a row of data.
                rs.moveToInsertRow();
                
                rs.updateInt("SalesOrderID", po.getSalesOrder().getSalesOrderDetail().getSalesOrderID());
                rs.updateInt("OrderQty", po.getSalesOrder().getSalesOrderDetail().getOrderQty());
                rs.updateInt("ProductID", po.getSalesOrder().getSalesOrderDetail().getProductID());
                rs.updateDouble("UnitPrice", po.getSalesOrder().getSalesOrderDetail().getUnitPrice());
                rs.updateDouble("UnitPriceDiscount", po.getSalesOrder().getSalesOrderDetail().getUnitPriceDiscount());
                //rs.updateDouble("LineTotal", po.getSalesOrder().getSalesOrderDetail().getLineTotal());
                rs.insertRow();
                
                //ProductDescription
                
                String SQL8 = "SELECT * FROM SalesLT.ProductDescription;";
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery(SQL8);
                
             // Insert a row of data.
                rs.moveToInsertRow();
                rs.updateString("Description", po.getSalesOrder().getSalesOrderDetail().getProduct().getProductModel().getModelDescription().getProductDescription().getDescription());
                rs.insertRow();
                
                
                //ModelDescription
                String SQL9 = "SELECT * FROM SalesLT.ProductModelProductDescription;";
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery(SQL9);
                
             // Insert a row of data.
                rs.moveToInsertRow();
                rs.updateInt("ProductModelID", po.getSalesOrder().getSalesOrderDetail().getProduct().getProductModel().getProductModelID());
                rs.updateInt("ProductDescriptionID", po.getSalesOrder().getSalesOrderDetail().getProduct().getProductModel().getModelDescription().getProductDescription().getProductDescriptionID());
                rs.updateString("Culture", po.getSalesOrder().getSalesOrderDetail().getProduct().getProductModel().getModelDescription().getCulture());
                rs.insertRow();            
                
            }
            catch (Exception e) {
                e.printStackTrace();
             }

             finally {
                if (rs != null) try { rs.close(); } catch(Exception e) {}
                if (stmt != null) try { stmt.close(); } catch(Exception e) {}
                if (con != null) try { con.close(); } catch(Exception e) {}
             }
           

		} catch (JAXBException je) {
			je.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
        
        //UnMarshalling code ends  
        
		
	}//Main
	
	
	
	//Convert dateTime of Sting form to XMLGregorianCalendar 
	XMLGregorianCalendar readDate(int column, String tableName, String pkey) {

		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
				+ "databaseName=AdventureWorksLT2008;integratedSecurity=true;";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		XMLGregorianCalendar xgcal = null;
		 
		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			Statement st = con.createStatement();

			String GET_RECORD = "select * from AdventureWorksLT2008.SalesLT."
					+ tableName + " where" + pkey;

			rs = st.executeQuery(GET_RECORD);

			String Demo = null;
			while (rs.next()) {
				Demo = rs.getString(column);

			}
		
			if(Demo == null)
				return null;
			
			
			StringTokenizer tk = new StringTokenizer(Demo, " ");
			int i = 0;
			String[] ar = new String[3];

			while (tk.hasMoreTokens()) {
				String token = (String) tk.nextToken();
				ar[i++] = token;
				// System.out.println(token);
			}

			 

			String[] ds = new String[3];

			i = 0;
			StringTokenizer dash = new StringTokenizer(ar[0], "-");
			while (dash.hasMoreTokens()) {
				String token = (String) dash.nextToken();
				ds[i++] = token;
				//System.out.println(token);
			}
			int year = Integer.parseInt(ds[0]);
			int month = Integer.parseInt(ds[1]);
			int day = Integer.parseInt(ds[2]);
			
			String []co = new String[3];
			i=0;
			StringTokenizer coln = new StringTokenizer(ar[1], ":");
			while ( coln.hasMoreTokens() )
			{
			  String token = (String)coln.nextToken();
			  co[i++] = token;
			  //System.out.println(token);
			}
			int hour = Integer.parseInt(co[0]);
			int min = Integer.parseInt(co[1]);
			String secc = co[2];
			
			String []dot = new String[3];
			i=0;
			StringTokenizer dd = new StringTokenizer(co[2], ".");
			while ( dd.hasMoreTokens() )
			{
			  String token = (String)dd.nextToken();
			  dot[i++] = token;
			  //System.out.println(token);
			}
			int sec = Integer.parseInt(dot[0]);
			String tt = dot[1];
			
			GregorianCalendar gcal = new GregorianCalendar();
			 
			gcal.set(year, month-1, day, hour, min, sec);
			
			
		     
			try {
				xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
			} catch (DatatypeConfigurationException e) {
				 
				e.printStackTrace();
			}
		   			
			rs.close();
			st.close();
			con.close();

			 
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return xgcal;
	}

}
