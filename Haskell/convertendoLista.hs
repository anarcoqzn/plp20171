main = do
    input <- getLine
    let nums1 = (map read $ words input :: [Int])
    input <- getLine
    let nums2 = (map read $ words input :: [Int])
    diferencaListas(nums1, nums2)


diferencaListas :: ([Int], [Int]) -> IO()
diferencaListas(x:[], y:[]) = print(x - y)
diferencaListas(x:xs, y:ys) = do
    let z = x - y
    print(z)
    diferencaListas(xs, ys)
