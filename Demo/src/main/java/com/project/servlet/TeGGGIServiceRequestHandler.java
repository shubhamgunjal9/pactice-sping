package com.project.servlet;
import java.util.logging.LogManager;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import com.bmw.tegggi.tegggiinterface.common.TeGGGIConstant;
import com.bmw.tegggi.tegggiinterface.common.TeGGGIErrorCode;
import com.bmw.tegggi.tegggiinterface.common.TeGGGIException;
import com.bmw.tegggi.tegggiinterface.common.TeGGGIUtil;
import com.bmw.tegggi.tegggiinterface.tegggisoawrapper.TeGGGIServiceImpl;
//
//import jakarta.jws.WebMethod;
//
//import jakarta.jws.WebParam;
//
//import jakarta.jws.WebService;
//
//import jakarta.jws.soap.SOAPBinding;

/**

* Class Description

* 

*/

@WebService(serviceName = "TeGGGIServiceRequestHandler", portName = "TeGGGIServiceRequestHandlerPort", targetNamespace = "http://tegggiwebservice.tegggiinterface.tegggi.bmw.com")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class TeGGGIServiceRequestHandler

{
 
	private static LogManager tegggiLogger_=LogManager.getLogger(TeGGGIServiceRequestHandler.class.getName());

    /**

     * getProjectInfo: Validates business user and returns the array of project

     * information of given business user

     * 

     * @param tegggiServiceRequestID

     *            session id

     * @param requesterUserID

     *            user id to login to teamcenter

     * @param requesterUserPwd

     *            password corresponding to requesterUserID

     * @param businessUserID

     *            user id for which project information is requested

     * @return projectInfo Array of string with alternate entry for project id

     *         and project name

     * @throws TeGGGIException

     *             returns {@link TeGGGIException}

     */

    @WebMethod

    public String[] getProjectInfo(

	    @WebParam(name = "tegggiServiceRequestID") String tegggiServiceRequestID,

	    @WebParam(name = "requesterUserID") String requesterUserID,

	    @WebParam(name = "requesterUserPwd") String requesterUserPwd,

	    @WebParam(name = "businessUserID") String businessUserID)

	    throws TeGGGIException

    {

	String[] projectInfo = null;

	TeGGGIServiceImpl tegggiImpl = new TeGGGIServiceImpl();

	//Abhijeet [2014-12-15] Start

    if(!checkString(tegggiServiceRequestID))

    {

        tegggiLogger_.info("Unique Service Request Id is empty");

        TeGGGIUtil.throwTeGGGIException("Unique Service Request Id is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

    }

    //Abhijeet [2014-12-15] End

	//14.20 Hot Fix Changes Start

	 if(!checkString(requesterUserID))

     {

	     tegggiLogger_.info("Requestor Id is empty");

	     TeGGGIUtil.throwTeGGGIException("Requestor Id is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

     }

     if(!checkString(requesterUserPwd))

     {

         tegggiLogger_.info("Requestor Password is empty");

         TeGGGIUtil.throwTeGGGIException("Requestor Password is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

     }

     if(!checkString(businessUserID))

     {

         tegggiLogger_.info("Business user id is empty");

         TeGGGIUtil.throwTeGGGIException("Business user id is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

     }

   //14.20 Hot Fix Changes End
 
	MDC.put("sessionID",tegggiServiceRequestID);

	tegggiLogger_.info(TeGGGIConstant.TEGGGI_CONSTANT_HEADER_STAR);

	tegggiLogger_.info("In TeGGGIServiceRequestHandler:getProjectInfo()");

	tegggiLogger_.info( "Input Details   :");

	tegggiLogger_.info( "requesterUserID :"+ requesterUserID);

	tegggiLogger_.info( "businessUserID  :"+ businessUserID);
 
	projectInfo = tegggiImpl.getProjectInfo(requesterUserID,requesterUserPwd, businessUserID);
 
	tegggiLogger_.info( "Output Details :");

	if (null != projectInfo)

	{
 
	    tegggiLogger_.info("Number of project returned :" + projectInfo.length / 2);

	    /*

	     * for(int index=0;index<projectInfo.length;index++) {

	     * tegggiLogger_.info

	     * ("projectInfo :"+projectInfo[index],

	     * TeGGGIServiceRequestHandler.class.getName()); }

	     */
 
	}

	tegggiLogger_.info("Exiting from the method TeGGGIServiceRequestHandler:getProjectInfo()");

	tegggiLogger_.info(TeGGGIConstant.TEGGGI_CONSTANT_HEADER_STAR);

	return projectInfo;
 
    }
 
    /**

     * getModuleInfo: returns module information from teamcenter

     * 

     * @param tegggiServiceRequestID

     *            unique session id

     * @param requesterUserID

     *            user id to login to teamcenter

     * @param requesterUserPwd

     *            password corresponding to requesterUserID

     * @return moduleInfo array of string containing Module Information

     * @throws TeGGGIException

     *             returns {@link TeGGGIException}

     */

    @WebMethod

    public String[] getModuleInfo(

	    @WebParam(name = "tegggiServiceRequestID") String tegggiServiceRequestID,

	    @WebParam(name = "requesterUserID") String requesterUserID,

	    @WebParam(name = "requesterUserPwd") String requesterUserPwd)

	    throws TeGGGIException

    {
 
      //14.20 Hot Fix Changes Start

      //Abhijeet [2014-12-15] Start

        if(!checkString(tegggiServiceRequestID))

        {

            tegggiLogger_.info("Unique Service Request Id is empty");

            TeGGGIUtil.throwTeGGGIException("Unique Service Request Id is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

        }

        //Abhijeet [2014-12-15] End

        if(!checkString(requesterUserID))

        {

            tegggiLogger_.info("Requestor Id is empty");

            TeGGGIUtil.throwTeGGGIException("Requestor Id is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

        }

        if(!checkString(requesterUserPwd))

        {

            tegggiLogger_.info("Requestor Password is empty");

            TeGGGIUtil.throwTeGGGIException("Requestor Password is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

        }

      //14.20 Hot Fix Changes End

	String[] moduleInfo = null;

	MDC.put("sessionID", tegggiServiceRequestID);

	tegggiLogger_.info(TeGGGIConstant.TEGGGI_CONSTANT_HEADER_STAR);

	tegggiLogger_.info("In TeGGGIServiceRequestHandler:getModuleInfo()");

	tegggiLogger_.info( "Input Details   :");

	tegggiLogger_.info( "requesterUserID :"+ requesterUserID);
 
	TeGGGIServiceImpl tegggiImpl = new TeGGGIServiceImpl();

	moduleInfo = tegggiImpl.getModuleInfo(requesterUserID, requesterUserPwd);
 
	tegggiLogger_.info("Output Details :");

	if (null != moduleInfo)

	{
 
	    tegggiLogger_.info("Size of Module information returned :" + moduleInfo.length/ 2);

	    /*

	     * for(int index=0;index<moduleInfo.length;index++) {

	     * tegggiLogger_.info

	     * ("moduleInfo :"+moduleInfo[index],

	     * TeGGGIServiceRequestHandler.class.getName()); }

	     */

	}
 
	tegggiLogger_.info("Exiting from the method TeGGGIServiceRequestHandler:getModuleInfo()");

	tegggiLogger_.info(TeGGGIConstant.TEGGGI_CONSTANT_HEADER_STAR);
 
	return moduleInfo;
 
    }
 
    /**

     * getJTFiles: downloads jt files from given UIDs to the mentioned location

     * and returns downloads status

     * 

     * @param tegggiServiceRequestID

     *            unique session id

     * @param requesterUserID

     *            user id for log in to teamcenter

     * @param requesterUserPwd

     *            password corresponding to requesterUserID

     * @param jtUidArray

     *            array of string containing UID of JT files to be downloaded

     * @param destLocationArray

     *            array of string containing path where JT files to be

     *            downloaded

     * @return downloadStatus an integer array with download status

     * @throws TeGGGIException

     *             returns {@link TeGGGIException}

     */

    @WebMethod

    public int[] getJTFiles(

	    @WebParam(name = "tegggiServiceRequestID") String tegggiServiceRequestID,

	    @WebParam(name = "requesterUserID") String requesterUserID,

	    @WebParam(name = "requesterUserPwd") String requesterUserPwd,

	    @WebParam(name = "jtUidArray") String[] jtUidArray,

	    @WebParam(name = "destLocationArray") String[] destLocationArray) throws TeGGGIException

    {
 
        //Abhijeet [2014-12-15] Start

        if(!checkString(tegggiServiceRequestID))

        {

            tegggiLogger_.info("Unique Service Request Id is empty");

            TeGGGIUtil.throwTeGGGIException("Unique Service Request Id is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

        }

        //Abhijeet [2014-12-15] End

        //14.20 Hot Fix Changes Start

        if(!checkString(requesterUserID))

        {

            tegggiLogger_.info("Requestor Id is empty");

            TeGGGIUtil.throwTeGGGIException("Requestor Id is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

        }      

        if(!checkString(requesterUserPwd))

        {

            tegggiLogger_.info("Requestor Password is empty");

            TeGGGIUtil.throwTeGGGIException("Requestor Password is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

        }

        /*Start [Abhijeet- 2014-12-17]

        if(!checkStringArray(jtUidArray))

        {

            tegggiLogger_.info("JT UID array is empty");            

            TeGGGIUtil.throwTeGGGIException("JT UID array is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

        }

        if(!checkStringArray(destLocationArray))

        {

            tegggiLogger_.info("Destination path array is empty");            

            TeGGGIUtil.throwTeGGGIException("Destination path array is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

        }

        End [Abhijeet- 2014-12-17]*/    

      //14.20 Hot Fix Changes End

        //Abhijeet [2014-12-15] Start

        if(jtUidArray.length != destLocationArray.length)

        {

            tegggiLogger_.info("Input JT UID Array and File Path Array Size mismatch.");

            TeGGGIUtil.throwTeGGGIException("Input JT UID Array and File Path Array Size mismatch.", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

        }

        //Abhijeet [2014-12-15] End


	int[] downloadStatus = null;

	MDC.put("sessionID", tegggiServiceRequestID);
 
	tegggiLogger_.info(TeGGGIConstant.TEGGGI_CONSTANT_HEADER_STAR);

	tegggiLogger_.info("In TeGGGIServiceRequestHandler:getJTFiles()");

	tegggiLogger_.info("Input Details     :");

	tegggiLogger_.info("requesterUserID   :"+ requesterUserID);

	tegggiLogger_.info("Number of input JTs received   :"+ jtUidArray.length);//14.20 Hot Fix Changes Start

	tegggiLogger_.info("Number of input file path received   :"+ destLocationArray.length);//14.20 Hot Fix Changes Start

	 //Abhijeet [2014-12-17] Start

        if (checkStringArray(jtUidArray) && checkStringArray(destLocationArray))

        {

	TeGGGIServiceImpl tegggiImpl = new TeGGGIServiceImpl();

	downloadStatus = tegggiImpl.getJTFiles(requesterUserID,requesterUserPwd, jtUidArray, destLocationArray);

        }

        else

        {

            downloadStatus = new int[0]; //to print status received for 0 JT files.

            tegggiLogger_.info("Empty JT UID and file path array received. The request will not be further processed.");            

        }

       //Abhijeet [2014-12-17] End

	tegggiLogger_.info( "Output Details      :");

	if (null != downloadStatus)

	{
 
	    tegggiLogger_.info("Download status received for " + downloadStatus.length + " JT files");

	}

	else

	{

	    tegggiLogger_.info("Download status Array is null.");

	}
 
	tegggiLogger_.info("Exiting from the method TeGGGIServiceRequestHandler:getJTFiles()");

	tegggiLogger_.info(TeGGGIConstant.TEGGGI_CONSTANT_HEADER_STAR);
 
	return downloadStatus;
 
    }
 
    /**

     * getProductStructureInfo: queries product structure info from Pirsma and

     * downloads the same to given location and returns download status

     * 

     * @param tegggiServiceRequestID

     *            unique session id

     * @param requesterUserID

     *            user id for log in to teamcenter

     * @param requesterUserPwd

     *            password corresponding to requesterUserID

     * @param businessUserID

     *            user id for which product structure information is sought

     * @param level

     *            bom level

     * @param rootNode

     *            rootnode of assembly

     * @param plmxmlFilePath

     *            Destination xml file location

     * @return downloadStatus an integer with 0 and 1 as possible values

     * @throws TeGGGIException

     *             returns {@link TeGGGIException}

     */

    @WebMethod

    public int getProductStructureInfo(

	    @WebParam(name = "tegggiServiceRequestID") String tegggiServiceRequestID,

	    @WebParam(name = "requesterUserID") String requesterUserID,

	    @WebParam(name = "requesterUserPwd") String requesterUserPwd,

	    @WebParam(name = "businessUserID") String businessUserID,

	    @WebParam(name = "level") int level,

	    @WebParam(name = "rootNode") String rootNode,

	    @WebParam(name = "plmxmlFilePath") String plmxmlFilePath)

	    throws TeGGGIException

    {

      //Abhijeet [2014-12-15] Start

        if(!checkString(tegggiServiceRequestID))

        {

            tegggiLogger_.info("Unique Service Request Id is empty");

            TeGGGIUtil.throwTeGGGIException("Unique Service Request Id is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

        }

        //Abhijeet [2014-12-15] End

      //14.20 Hot Fix Changes Start

        if(!checkString(requesterUserID))

        {

            tegggiLogger_.info("Requestor Id is empty");

            TeGGGIUtil.throwTeGGGIException("Requestor Id is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

        }

        if(!checkString(requesterUserPwd))

        {

            tegggiLogger_.info("Requestor Password is empty");

            TeGGGIUtil.throwTeGGGIException("Requestor Password is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

        }

        if(!checkString(businessUserID))

        {

            tegggiLogger_.info("Business user id is empty");

            TeGGGIUtil.throwTeGGGIException("Business user id is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

        }

        if(!checkString(rootNode))

        {

            tegggiLogger_.info("Rootnode is empty");

            TeGGGIUtil.throwTeGGGIException("Rootnode is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

        }

        if(!checkString(plmxmlFilePath))

        {

            tegggiLogger_.info("PLMXML file path is empty");

            TeGGGIUtil.throwTeGGGIException("PLMXML file path is empty", TeGGGIErrorCode.MISSING_PARAMETERS.getErrorCode());

        }

      //14.20 Hot Fix Changes End
 
	int downloadStatus = 0;

	TeGGGIServiceImpl tegggiImpl = new TeGGGIServiceImpl();

	MDC.put("sessionID", tegggiServiceRequestID);
 
	tegggiLogger_.info(TeGGGIConstant.TEGGGI_CONSTANT_HEADER_STAR);

	tegggiLogger_.info("In TeGGGIServiceRequestHandler:getProductStructureInfo()");

	tegggiLogger_.info( "Input Details     :");

	tegggiLogger_.info( "requesterUserID   :"+ requesterUserID);

	tegggiLogger_.info( "businessUserID    :"+ businessUserID.toString());

	tegggiLogger_.info( "level             :"+ level);

	tegggiLogger_.info( "rootNode          :"+ rootNode);

	tegggiLogger_.info( "plmxmlFilePath    :"+ plmxmlFilePath);
 
	downloadStatus = tegggiImpl.getProductStructureInfo(requesterUserID,

		requesterUserPwd, businessUserID, level, rootNode,

		plmxmlFilePath);
 
	tegggiLogger_.info("Output Details      :");

	tegggiLogger_.info( "DownloadStatus     :"+ downloadStatus);

	tegggiLogger_.info("Exiting from the method TeGGGIServiceRequestHandler:getProductStructureInfo()");

	tegggiLogger_.info(TeGGGIConstant.TEGGGI_CONSTANT_HEADER_STAR);
 
	return downloadStatus;
 
    }
 
    //14.20 Hot Fix Changes Start

    /**

     * @param inputArray Input Array

     * @return Status

     */

    public boolean checkStringArray(String inputArray[])

    {

        boolean status = false;

        if(inputArray!=null && inputArray.length > 0)

        {

            status = true;

}

        return status;

    }

    /**

     * @param inputString Input String

     * @return Status

     */

    public boolean checkString(String inputString)

    {

        boolean status = false;

        if(inputString != null && !inputString.isEmpty())

        {

            status = true;

        }

        return status;

    }

  //14.20 Hot Fix Changes End
 
}