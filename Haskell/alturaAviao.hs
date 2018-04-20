main = do
    x <- getLine
    let alturaIdeal = read x :: Int
    estabilizaAviao(alturaIdeal)
    

estabilizaAviao :: Int -> (IO)
estabilizaAviao (alturaIdeal)
    = do
      y <- getLine
      let altura = read y :: Int
      if(limiteAtual(alturaIdeal, altura) == 0) then putStrLn("OK")
      else if(limiteAtual(alturaIdeal, altura) >= 0) then putStrLn("PERIGO") ++ estabilizaAviao(alturaIdeal)
      else putStrLn("ADEQUADO") ++ estabilizaAviao(alturaIdeal)

limiteAtual :: (Int, Int) -> Int
limiteAtual (x, y) = x - y 
