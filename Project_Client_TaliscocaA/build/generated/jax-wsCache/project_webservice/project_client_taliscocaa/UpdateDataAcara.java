
package project_client_taliscocaa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateDataAcara complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateDataAcara"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="status_acara" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="kapasitas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="acara_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateDataAcara", propOrder = {
    "statusAcara",
    "kapasitas",
    "acaraId"
})
public class UpdateDataAcara {

    @XmlElement(name = "status_acara")
    protected String statusAcara;
    protected int kapasitas;
    @XmlElement(name = "acara_id")
    protected int acaraId;

    /**
     * Gets the value of the statusAcara property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusAcara() {
        return statusAcara;
    }

    /**
     * Sets the value of the statusAcara property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusAcara(String value) {
        this.statusAcara = value;
    }

    /**
     * Gets the value of the kapasitas property.
     * 
     */
    public int getKapasitas() {
        return kapasitas;
    }

    /**
     * Sets the value of the kapasitas property.
     * 
     */
    public void setKapasitas(int value) {
        this.kapasitas = value;
    }

    /**
     * Gets the value of the acaraId property.
     * 
     */
    public int getAcaraId() {
        return acaraId;
    }

    /**
     * Sets the value of the acaraId property.
     * 
     */
    public void setAcaraId(int value) {
        this.acaraId = value;
    }

}
