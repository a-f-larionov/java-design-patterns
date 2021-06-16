package patterns.structural.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExpensiveObjectImpl implements ExpensiveObject {

    public ExpensiveObjectImpl() {
        heavyInit();
    }

    private void heavyInit() {
        log.info("Heavy init");
    }

    @Override
    public void process() {
        log.info("Process expensive object impl");
    }
}
