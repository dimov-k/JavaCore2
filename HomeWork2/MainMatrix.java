public class MainMatrix {

    public static String matrixString = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    public static int stringTo4x4Matrix = 4;
    public static String[][] strArray;

    public static void main(String[] args) {

        try {
            strArray = string_toArray(matrixString, stringTo4x4Matrix);
            try {
                printArraySqr(strArray, "1)Имеется Массив:\n");
                System.out.println("2)Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2 \n Результат = " + getSumArray(strArray));
            }
            catch (ExceptMatrix e){
                e.printStackTrace();
            }
        }
        catch (ExceptMatrix e){
            e.printStackTrace();
        }
    }


    public static int count(String str, String subString) {
        return (str.length() - str.replace(subString, "").length()) / subString.length();
    }

    public static float getSumArray(String[][] strArray) throws ExceptMatrix {
        float result = 0;

        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length; j++) {

                try {
                    result += Float.parseFloat(strArray[i][j]);
                } catch (NumberFormatException e){
                    throw new ExceptMatrix("4)Ошибка!!! преобразования к числу типа int");}
            }
        }

        return result / 2;
    }

    public static String[][] string_toArray(String str, int SizeArray) throws ExceptMatrix {

        String[][] result = new String[SizeArray][SizeArray];
        String lineSeparator = "\n";
        String elementSeparator = " ";
//Проверка массива на размер, если не соответствует, возвращаем ошибку.
        int countI = count(str, lineSeparator);
        int countJ = count(str, elementSeparator);
        if((countI == SizeArray - 1 || (countI == SizeArray && str.endsWith(lineSeparator)))
                &&((int) (countJ / SizeArray) == SizeArray - 1 && countJ % SizeArray == 0)){

            int endIndexStr = str.indexOf(lineSeparator);
            for (int i = 0; i < SizeArray; i++) {
                String strTemp = str.substring(0,endIndexStr) + " ";
                str = str.substring(endIndexStr + 1);
                for (int j = 0; j < SizeArray; j++) {
                    endIndexStr = strTemp.indexOf(elementSeparator);
                    result[i][j] = strTemp.substring(0, endIndexStr);
                    strTemp = strTemp.substring(endIndexStr + 1);
                }
                endIndexStr = str.indexOf(lineSeparator);
                if(endIndexStr == -1 && i != SizeArray - 1){
                    endIndexStr = str.length();
                    str += lineSeparator;
                }
            }
        }
        else{
            throw new ExceptMatrix("3)Размер матрицы, полученной из строки, не равен 4x4 " + SizeArray + "Х" + SizeArray);
        }
        return result;
    }

    public static void printArraySqr(String[][] array, String massage){
        System.out.print(massage);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
