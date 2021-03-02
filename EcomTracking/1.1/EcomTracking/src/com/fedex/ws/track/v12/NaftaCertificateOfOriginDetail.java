
package com.fedex.ws.track.v12;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Data required to produce a Certificate of Origin document. Remaining content (business data) to be defined once requirements have been completed.
 * 
 * <p>Clase Java para NaftaCertificateOfOriginDetail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="NaftaCertificateOfOriginDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Format" type="{http://fedex.com/ws/ship/v19}ShippingDocumentFormat" minOccurs="0"/>
 *         &lt;element name="BlanketPeriod" type="{http://fedex.com/ws/ship/v19}DateRange" minOccurs="0"/>
 *         &lt;element name="ImporterSpecification" type="{http://fedex.com/ws/ship/v19}NaftaImporterSpecificationType" minOccurs="0"/>
 *         &lt;element name="SignatureContact" type="{http://fedex.com/ws/ship/v19}Contact" minOccurs="0"/>
 *         &lt;element name="ProducerSpecification" type="{http://fedex.com/ws/ship/v19}NaftaProducerSpecificationType" minOccurs="0"/>
 *         &lt;element name="Producers" type="{http://fedex.com/ws/ship/v19}NaftaProducer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CustomerImageUsages" type="{http://fedex.com/ws/ship/v19}CustomerImageUsage" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaftaCertificateOfOriginDetail", propOrder = {
    "format",
    "blanketPeriod",
    "importerSpecification",
    "signatureContact",
    "producerSpecification",
    "producers",
    "customerImageUsages"
})
public class NaftaCertificateOfOriginDetail {

    @XmlElement(name = "Format")
    protected ShippingDocumentFormat format;
    @XmlElement(name = "BlanketPeriod")
    protected DateRange blanketPeriod;
    @XmlElement(name = "ImporterSpecification")
    protected NaftaImporterSpecificationType importerSpecification;
    @XmlElement(name = "SignatureContact")
    protected Contact signatureContact;
    @XmlElement(name = "ProducerSpecification")
    protected NaftaProducerSpecificationType producerSpecification;
    @XmlElement(name = "Producers")
    protected List<NaftaProducer> producers;
    @XmlElement(name = "CustomerImageUsages")
    protected List<CustomerImageUsage> customerImageUsages;

    /**
     * Obtiene el valor de la propiedad format.
     * 
     * @return
     *     possible object is
     *     {@link ShippingDocumentFormat }
     *     
     */
    public ShippingDocumentFormat getFormat() {
        return format;
    }

    /**
     * Define el valor de la propiedad format.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingDocumentFormat }
     *     
     */
    public void setFormat(ShippingDocumentFormat value) {
        this.format = value;
    }

    /**
     * Obtiene el valor de la propiedad blanketPeriod.
     * 
     * @return
     *     possible object is
     *     {@link DateRange }
     *     
     */
    public DateRange getBlanketPeriod() {
        return blanketPeriod;
    }

    /**
     * Define el valor de la propiedad blanketPeriod.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRange }
     *     
     */
    public void setBlanketPeriod(DateRange value) {
        this.blanketPeriod = value;
    }

    /**
     * Obtiene el valor de la propiedad importerSpecification.
     * 
     * @return
     *     possible object is
     *     {@link NaftaImporterSpecificationType }
     *     
     */
    public NaftaImporterSpecificationType getImporterSpecification() {
        return importerSpecification;
    }

    /**
     * Define el valor de la propiedad importerSpecification.
     * 
     * @param value
     *     allowed object is
     *     {@link NaftaImporterSpecificationType }
     *     
     */
    public void setImporterSpecification(NaftaImporterSpecificationType value) {
        this.importerSpecification = value;
    }

    /**
     * Obtiene el valor de la propiedad signatureContact.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getSignatureContact() {
        return signatureContact;
    }

    /**
     * Define el valor de la propiedad signatureContact.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setSignatureContact(Contact value) {
        this.signatureContact = value;
    }

    /**
     * Obtiene el valor de la propiedad producerSpecification.
     * 
     * @return
     *     possible object is
     *     {@link NaftaProducerSpecificationType }
     *     
     */
    public NaftaProducerSpecificationType getProducerSpecification() {
        return producerSpecification;
    }

    /**
     * Define el valor de la propiedad producerSpecification.
     * 
     * @param value
     *     allowed object is
     *     {@link NaftaProducerSpecificationType }
     *     
     */
    public void setProducerSpecification(NaftaProducerSpecificationType value) {
        this.producerSpecification = value;
    }

    /**
     * Gets the value of the producers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the producers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProducers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NaftaProducer }
     * 
     * 
     */
    public List<NaftaProducer> getProducers() {
        if (producers == null) {
            producers = new ArrayList<NaftaProducer>();
        }
        return this.producers;
    }

    /**
     * Gets the value of the customerImageUsages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerImageUsages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerImageUsages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerImageUsage }
     * 
     * 
     */
    public List<CustomerImageUsage> getCustomerImageUsages() {
        if (customerImageUsages == null) {
            customerImageUsages = new ArrayList<CustomerImageUsage>();
        }
        return this.customerImageUsages;
    }

}
