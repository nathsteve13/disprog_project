
package project_client_taliscocaa;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.5
 * Generated source version: 2.2
 * 
 */
@WebService(name = "project_webservice", targetNamespace = "http://services.project_webservice.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ProjectWebservice {


    /**
     * 
     * @param password
     * @param nama
     * @param email
     * @param username
     */
    @WebMethod
    @RequestWrapper(localName = "insertDataUser", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.InsertDataUser")
    @ResponseWrapper(localName = "insertDataUserResponse", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.InsertDataUserResponse")
    @Action(input = "http://services.project_webservice.com/project_webservice/insertDataUserRequest", output = "http://services.project_webservice.com/project_webservice/insertDataUserResponse")
    public void insertDataUser(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "nama", targetNamespace = "")
        String nama,
        @WebParam(name = "email", targetNamespace = "")
        String email);

    /**
     * 
     * @param acaraId
     * @param kapasitas
     * @param statusAcara
     */
    @WebMethod
    @RequestWrapper(localName = "updateDataAcara", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.UpdateDataAcara")
    @ResponseWrapper(localName = "updateDataAcaraResponse", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.UpdateDataAcaraResponse")
    @Action(input = "http://services.project_webservice.com/project_webservice/updateDataAcaraRequest", output = "http://services.project_webservice.com/project_webservice/updateDataAcaraResponse")
    public void updateDataAcara(
        @WebParam(name = "status_acara", targetNamespace = "")
        String statusAcara,
        @WebParam(name = "kapasitas", targetNamespace = "")
        int kapasitas,
        @WebParam(name = "acara_id", targetNamespace = "")
        int acaraId);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "viewListDataParking", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.ViewListDataParking")
    @ResponseWrapper(localName = "viewListDataParkingResponse", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.ViewListDataParkingResponse")
    @Action(input = "http://services.project_webservice.com/project_webservice/viewListDataParkingRequest", output = "http://services.project_webservice.com/project_webservice/viewListDataParkingResponse")
    public List<String> viewListDataParking();

    /**
     * 
     * @param parkingId
     * @param totalSlotparkir
     * @param statusParking
     */
    @WebMethod
    @RequestWrapper(localName = "updateDataParking", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.UpdateDataParking")
    @ResponseWrapper(localName = "updateDataParkingResponse", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.UpdateDataParkingResponse")
    @Action(input = "http://services.project_webservice.com/project_webservice/updateDataParkingRequest", output = "http://services.project_webservice.com/project_webservice/updateDataParkingResponse")
    public void updateDataParking(
        @WebParam(name = "parking_id", targetNamespace = "")
        int parkingId,
        @WebParam(name = "total_slotparkir", targetNamespace = "")
        int totalSlotparkir,
        @WebParam(name = "status_parking", targetNamespace = "")
        String statusParking);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "viewListDataAcara", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.ViewListDataAcara")
    @ResponseWrapper(localName = "viewListDataAcaraResponse", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.ViewListDataAcaraResponse")
    @Action(input = "http://services.project_webservice.com/project_webservice/viewListDataAcaraRequest", output = "http://services.project_webservice.com/project_webservice/viewListDataAcaraResponse")
    public List<String> viewListDataAcara();

    /**
     * 
     * @param userId
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "viewListDataReservasiAcara", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.ViewListDataReservasiAcara")
    @ResponseWrapper(localName = "viewListDataReservasiAcaraResponse", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.ViewListDataReservasiAcaraResponse")
    @Action(input = "http://services.project_webservice.com/project_webservice/viewListDataReservasiAcaraRequest", output = "http://services.project_webservice.com/project_webservice/viewListDataReservasiAcaraResponse")
    public List<String> viewListDataReservasiAcara(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @param reservasiId
     */
    @WebMethod
    @RequestWrapper(localName = "updateDataReservasiAcara", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.UpdateDataReservasiAcara")
    @ResponseWrapper(localName = "updateDataReservasiAcaraResponse", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.UpdateDataReservasiAcaraResponse")
    @Action(input = "http://services.project_webservice.com/project_webservice/updateDataReservasiAcaraRequest", output = "http://services.project_webservice.com/project_webservice/updateDataReservasiAcaraResponse")
    public void updateDataReservasiAcara(
        @WebParam(name = "reservasi_id", targetNamespace = "")
        int reservasiId);

    /**
     * 
     * @param acaraId
     * @param userId
     * @param jumlahTiket
     */
    @WebMethod
    @RequestWrapper(localName = "insertDataReservasiAcara", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.InsertDataReservasiAcara")
    @ResponseWrapper(localName = "insertDataReservasiAcaraResponse", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.InsertDataReservasiAcaraResponse")
    @Action(input = "http://services.project_webservice.com/project_webservice/insertDataReservasiAcaraRequest", output = "http://services.project_webservice.com/project_webservice/insertDataReservasiAcaraResponse")
    public void insertDataReservasiAcara(
        @WebParam(name = "jumlah_tiket", targetNamespace = "")
        int jumlahTiket,
        @WebParam(name = "user_id", targetNamespace = "")
        int userId,
        @WebParam(name = "acara_id", targetNamespace = "")
        int acaraId);

    /**
     * 
     * @param email
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkEmail", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.CheckEmail")
    @ResponseWrapper(localName = "checkEmailResponse", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.CheckEmailResponse")
    @Action(input = "http://services.project_webservice.com/project_webservice/checkEmailRequest", output = "http://services.project_webservice.com/project_webservice/checkEmailResponse")
    public boolean checkEmail(
        @WebParam(name = "email", targetNamespace = "")
        String email);

    /**
     * 
     * @param password
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkLogin", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.CheckLogin")
    @ResponseWrapper(localName = "checkLoginResponse", targetNamespace = "http://services.project_webservice.com/", className = "project_client_taliscocaa.CheckLoginResponse")
    @Action(input = "http://services.project_webservice.com/project_webservice/checkLoginRequest", output = "http://services.project_webservice.com/project_webservice/checkLoginResponse")
    public String checkLogin(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password);

}
