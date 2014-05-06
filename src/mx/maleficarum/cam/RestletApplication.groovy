import mx.maleficarum.cam.CamBackup
import mx.maleficarum.cam.CamList
import mx.maleficarum.cam.CamStart
import mx.maleficarum.cam.CamStatus
import mx.maleficarum.cam.CamStop
import org.restlet.Application
import org.restlet.Component
import org.restlet.Restlet
import org.restlet.data.Protocol
import org.restlet.routing.Router

Application application = new Application() {

    public synchronized Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/cams/status",CamStatus.class );
        router.attach("/cams/start",CamStart.class );
        router.attach("/cams/stop",CamStop.class );
        router.attach("/cams/backup",CamBackup.class );
        router.attach("/cams/list",CamList.class );
        return router;
    }
};

Component component = new Component()
component.getServers().add(Protocol.HTTP, 8080)
component.getClients().add(Protocol.FILE);
component.getDefaultHost().attach(application);
component.start()
