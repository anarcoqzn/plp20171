main = do
    x <- getLine
    let alturaIdeal = read x :: Int
    estabilizaAviao(alturaIdeal, 0)
    

estabilizaAviao :: (Int, Int) -> IO()
estabilizaAviao (alturaIdeal, limite)
    = do
      y <- getLine
      let altura = read y :: Int
      
      if limiteAtual(alturaIdeal, altura) == 0 then putStrLn("OK")
      else if limiteAtual(alturaIdeal, altura) > limite then putStrLn("PERIGO" ++ estabilizaAviao(alturaIdeal, limite))
      else putStrLn("ADEQUADO" ++ estabilizaAviao(alturaIdeal, limiteAtual(alturaIdeal, altura)))

limiteAtual :: (Int, Int) -> Int
limiteAtual (x, y)
    | x >= y = x - y
    | otherwise = y - x
