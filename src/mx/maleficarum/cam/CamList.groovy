package mx.maleficarum.cam

import org.restlet.data.MediaType
import org.restlet.representation.Representation
import org.restlet.representation.StringRepresentation
import org.restlet.resource.Get
import org.restlet.resource.ServerResource

/**
 * Created with IntelliJ IDEA.
 * User: oscar
 * Date: 5/5/14
 * Time: 10:31 PM
 * To change this template use File | Settings | File Templates.
 */
class CamList extends ServerResource {

    @Get
    public Representation doGet(){
        def response = new StringBuffer()
        def files = []
        new File("/home/oscar/projects/maleficarum/cam-restlet/config/motion.conf").eachLine {
            if(it =~ "thread" && !(it =~ ";")) {//Has many cameras ... read each line and open corresponding config file
                files << it.split(" ")[1]
            }
        }

        response.append("{files:[")
        files.each { file ->
            //new File(file).eachLine {
                response.append("{name:'$file'},")
            //}
        }
        response.append("]}")
        return new StringRepresentation(response.toString().replaceAll("},]}","}]}"), MediaType.APPLICATION_JSON)
    }
}
