import request from '@/utils/request'

// 查询advise列表
export function listAdvise(query) {
  return request({
    url: '/utrain/advise/list',
    method: 'get',
    params: query
  })
}

// 查询advise详细
export function getAdvise(id) {
  return request({
    url: '/utrain/advise/' + id,
    method: 'get'
  })
}

// 新增advise
export function addAdvise(data) {
  return request({
    url: '/utrain/advise',
    method: 'post',
    data: data
  })
}

// 修改advise
export function updateAdvise(data) {
  return request({
    url: '/utrain/advise',
    method: 'put',
    data: data
  })
}

// 删除advise
export function delAdvise(id) {
  return request({
    url: '/utrain/advise/' + id,
    method: 'delete'
  })
}
