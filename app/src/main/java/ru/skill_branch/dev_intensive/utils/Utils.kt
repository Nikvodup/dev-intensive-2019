package ru.skill_branch.dev_intensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?,String?>{

        val parts:List<String>?= fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return Pair(firstName,lastName)
       // return firstName to lastName

    }

   fun transliteration(payload:String, divider:String = " "): String{


       val letters = mutableMapOf<String, String>()

           letters.put("А", "A");
           letters.put("Б", "B");
           letters.put("В", "V");
           letters.put("Г", "G");
           letters.put("Д", "D");
           letters.put("Е", "E");
           letters.put("Ё", "E");
           letters.put("Ж", "Zh");
           letters.put("З", "Z");
           letters.put("И", "I");
           letters.put("Й", "I");
           letters.put("К", "K");
           letters.put("Л", "L");
           letters.put("М", "M");
           letters.put("Н", "N");
           letters.put("О", "O");
           letters.put("П", "P");
           letters.put("Р", "R");
           letters.put("С", "S");
           letters.put("Т", "T");
           letters.put("У", "U");
           letters.put("Ф", "F");
           letters.put("Х", "Kh");
           letters.put("Ц", "C");
           letters.put("Ч", "Ch");
           letters.put("Ш", "Sh");
           letters.put("Щ", "Sch");
           letters.put("Ъ", "'");
           letters.put("Ы", "Y");
           letters.put("Ъ", "'");
           letters.put("Э", "E");
           letters.put("Ю", "Yu");
           letters.put("Я", "Ya");
           letters.put("а", "a");
           letters.put("б", "b");
           letters.put("в", "v");
           letters.put("г", "g");
           letters.put("д", "d");
           letters.put("е", "e");
           letters.put("ё", "e");
           letters.put("ж", "zh");
           letters.put("з", "z");
           letters.put("и", "i");
           letters.put("й", "i");
           letters.put("к", "k");
           letters.put("л", "l");
           letters.put("м", "m");
           letters.put("н", "n");
           letters.put("о", "o");
           letters.put("п", "p");
           letters.put("р", "r");
           letters.put("с", "s");
           letters.put("т", "t");
           letters.put("у", "u");
           letters.put("ф", "f");
           letters.put("х", "h");
           letters.put("ц", "c");
           letters.put("ч", "ch");
           letters.put("ш", "sh");
           letters.put("щ", "sch");
           letters.put("ъ", "'");
           letters.put("ы", "y");
           letters.put("ъ", "'");
           letters.put("э", "e");
           letters.put("ю", "yu");
           letters.put("я", "ya");

           var sb =  StringBuilder(payload.length);

          for( i in 0..payload.length-1) {
              var l: String = payload.substring(i, i + 1);
              if (letters.containsKey(l)) {
                  sb.append(letters.get(l));
              } else {
                  sb.append(l);
              }
          }
           return sb.toString();
   }

    fun toInitials(firstName:String?,lastName:String?): MutableList<String> {
        return mutableListOf(firstName!!.substring(0,1)+"."+lastName!!.substring(0,1)+".")
    }
}