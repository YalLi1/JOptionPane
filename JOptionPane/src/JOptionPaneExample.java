import javax.swing.*;
import java.awt.event.*;

public class JOptionPaneExample extends JFrame implements KeyListener {

    public JOptionPaneExample() {
        // Настройка фрейма
        setTitle("Name Input Example");

        // Вызов диалогового окна для выбора разрешения экрана
        showResolutionDialog();

        // Настройка клавиатурного слушателя
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Метод для отображения диалогового окна с выбором разрешения экрана
    private void showResolutionDialog() {
        String[] resolutions = {"800x600", "1024x768", "1280x1024", "1920x1080"};
        JComboBox<String> resolutionList = new JComboBox<>(resolutions);
        int result = JOptionPane.showConfirmDialog(this, resolutionList, "Выберите разрешение экрана", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String selectedResolution = (String) resolutionList.getSelectedItem();
            if (selectedResolution != null) {
                String[] dimensions = selectedResolution.split("x");
                int width = Integer.parseInt(dimensions[0]);
                int height = Integer.parseInt(dimensions[1]);
                setSize(width, height); // Установка размера фрейма в соответствии с выбранным разрешением
            }
        } else {
            System.exit(0); // Закрываем программу, если пользователь нажал "Cancel"
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Отображение диалогового окна для ввода имени при нажатии пробела
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            // Ввод имени пользователя
            String name = JOptionPane.showInputDialog(this, "Введите ваше имя:");
            if (name != null && !name.trim().isEmpty()) {
                // Отображение сообщений с вопросами Да/Нет
                int firstQuestion = JOptionPane.showConfirmDialog(this, "Вам нравится кофе?", "Вопрос 1", JOptionPane.YES_NO_OPTION);
                int secondQuestion = JOptionPane.showConfirmDialog(this, "Вы любите путешествовать?", "Вопрос 2", JOptionPane.YES_NO_OPTION);

                // Определение и отображение ответа в зависимости от комбинации ответов
                String message = "";
                if (firstQuestion == JOptionPane.YES_OPTION && secondQuestion == JOptionPane.YES_OPTION) {
                    message = "Привет, " + name + "! Вы любите кофе и путешествия. Отличный выбор!";
                } else if (firstQuestion == JOptionPane.YES_OPTION && secondQuestion == JOptionPane.NO_OPTION) {
                    message = "Привет, " + name + "! Вы любите кофе, но не любите путешествия.";
                } else if (firstQuestion == JOptionPane.NO_OPTION && secondQuestion == JOptionPane.YES_OPTION) {
                    message = "Привет, " + name + "! Вы не любите кофе, но любите путешествия.";
                } else if (firstQuestion == JOptionPane.NO_OPTION && secondQuestion == JOptionPane.NO_OPTION) {
                    message = "Привет, " + name + "! Вы не любите ни кофе, ни путешествия.";
                }

                // Отображение итогового сообщения
                JOptionPane.showMessageDialog(this, message);
            } else {
                // Если имя не введено или пустое, отображаем соответствующее сообщение
                JOptionPane.showMessageDialog(this, "Вы не ввели имя.");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Не используется
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Не используется
    }

}
