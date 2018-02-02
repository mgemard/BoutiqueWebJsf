import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class BoutiquePhaseListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        // System.out.println("Fin de la phase" + event.getPhaseId());
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        // System.out.println("Début de la phase" + event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
