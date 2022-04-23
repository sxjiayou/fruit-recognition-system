import request from '@/utils/request'

// 查询sportdata列表
export function listSportdata(query) {
  return request({
    url: '/utrain/sportdata/list',
    method: 'get',
    params: query
  })
}

// 查询sportdata详细
export function getSportdata(qid) {
  return request({
    url: '/utrain/sportdata/' + qid,
    method: 'get'
  })
}

// 新增sportdata
export function addSportdata(data) {
  return request({
    url: '/utrain/sportdata',
    method: 'post',
    data: data
  })
}

// 修改sportdata
export function updateSportdata(data) {
  return request({
    url: '/utrain/sportdata',
    method: 'put',
    data: data
  })
}

// 删除sportdata
export function delSportdata(qid) {
  return request({
    url: '/utrain/sportdata/' + qid,
    method: 'delete'
  })
}
