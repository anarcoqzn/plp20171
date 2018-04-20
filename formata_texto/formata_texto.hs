main = do
    putStrLn("Digite o texto:")
    texto <- getLine
    
    putStrLn "Digite o numero de caraceteres por linha:"
    input <- getLine
    let numChars = read input :: Int
    
    putStrLn "Digite o numero de linhas por pagina:"
    input <- getLine
    let numLinhas = read input :: Int
    
    putStrLn "Word Wrap? (Sim/Nao):"
    wordWrap <- getLine
    imprimeTextoFormatado(texto, numChars, numLinhas, wordWrap)
