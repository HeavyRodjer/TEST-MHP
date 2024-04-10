package common;

public class config {
    /** Обераєм браузера і платформу для тестування
     *
     */
    public static final String PLATFORM_AND_BROWSER = "EdgeDriver";
    /**
     *  Чи очищати кукі в браузері після проходження тесту
     */
    public static final Boolean CLEAR_COOLIES = false;
    /**
     * Чи закривати браузер після проходження тесту
     */
    public static final Boolean HOLD_BROWSER_OPEN = true;
    /**
     * Чи потрібно очистити скріншоти, після тесту
     */
    public  static final Boolean CLEAR_REPORTS_DIR = true;
}
