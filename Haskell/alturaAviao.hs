main = do
    x <- getLine
    let alturaIdeal = read x :: Int
    y <- getLine
    let alturaAtual = read y :: Int    
    estabilizaAviao(alturaIdeal, limiteAtual(alturaIdeal, alturaAtual))

estabilizaAviao :: (Int, Int) -> IO()
estabilizaAviao(alturaIdeal, limitante) = do
    y <- getLine
    let alturaAtual = read y :: Int
    let limite = limiteAtual(alturaIdeal, alturaAtual)
    
    if(limite == 0) then
        putStrLn "OK"
    else
        if(limite < limitante) then do
            putStrLn "ADEQUADO"
            estabilizaAviao(alturaIdeal, limite)
        else do
            putStrLn "PERIGO"
            estabilizaAviao(alturaIdeal, limite)
      
limiteAtual :: (Int, Int) -> Int
limiteAtual(x, y)
    | (x >= y) = x - y
    | otherwise = y - x
