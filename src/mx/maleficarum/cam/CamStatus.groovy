package mx.maleficarum.cam

import org.restlet.data.MediaType
import org.restlet.representation.Representation
import org.restlet.representation.StringRepresentation
import org.restlet.resource.Get
import org.restlet.resource.ServerResource

/**
 * Created with IntelliJ IDEA.
 * User: oscar
 * Date: 1/5/14
 * Time: 11:35 AM
 * To change this template use File | Settings | File Templates.
 */
class CamStatus extends ServerResource {

    @Get
    public Representation doGet(){
        def sout = new StringBuffer(), serr = new StringBuffer()
        /*def proc = "/home/pi/bin/status".execute()
        proc.consumeProcessOutput(sout, serr)
        proc.waitForOrKill(1000)*/
        def exists = sout && !serr ? true : false
        return new StringRepresentation("{\"std\":${exists}, \"err\":\"${serr}\"}", MediaType.APPLICATION_JSON);
    }
}
