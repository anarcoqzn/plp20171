main = do
    input1 <- getLine
    input2 <- getLine
    input3 <- getLine
    input4 <- getLine
    input5 <- getLine
    putStrLn(ehVogal(last(input1)) ++ ehVogal(last(input2)) ++ ehVogal(last(input3)) ++ ehVogal(last(input4)) ++ ehVogal(last(input5)))

ehVogal :: Char -> String
ehVogal letra
    | (letra == 'a') || (letra == 'A') = "a"
    | (letra == 'e') || (letra == 'E') = "e"
    | (letra == 'i') || (letra == 'I') = "i"
    | (letra == 'o') || (letra == 'O') = "o"
    | (letra == 'u') || (letra == 'U') = "u"
    | otherwise = ""
