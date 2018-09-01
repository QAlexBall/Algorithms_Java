***
##### Generate Parenthesis
只有知道序列仍然保持有效时再添加'(' or ')'.
通过跟踪到目前为止放置的左括号和又括号的数目来做到这一点.
```python
class Solution(object):
    def generateParenthesis(self, N):
        ans = []
        def backtrack(S = '', left = 0, right = 0):
            if len(S) == 2 * N:
                ans.append(S)
                return
            if left < N:
                backtrack(S+'(', left+1, right)
            if right < left:
                backtrack(S+')', left, right+1)

        backtrack()
        return ans

```
