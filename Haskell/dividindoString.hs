main = do
    input <- getLine
    let palavras = (words input)
    input <- getLine
    let adjetivos = (words input)
    putStrLn(concatenaStrings(palavras, adjetivos))


concatenaStrings :: ([String], [String]) -> String
concatenaStrings ([], [])  = ""
concatenaStrings(c:cs, h:hs) = c ++ " " ++ h ++ "\n" ++ concatenaStrings(cs, hs)
