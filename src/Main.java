import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");
        String input = scanner.nextLine();

        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println("Ошибка: "+ e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        input = input.replaceAll("\\s+", "");
        char operator = ' ';
        for (char ch : input.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                operator = ch;
                break;
            }
        }
        if (operator == ' ') {
            throw new Exception("т.к строка не является математической операцией");
        }
        String[] parts = input.split("\\" + operator);
        if (parts.length != 2) {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        int a, b;
        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            throw new Exception("т.к. операнды должны быть целыми числами");
        }
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("т. к. операнды должны быть числами от 1 до 10");
        }
        int result = switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new Exception("неизвестная операция.");
        };

        return String.valueOf(result);
    }
}